package open.cklan.com.library.widget.refresh.adapter;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import open.cklan.com.library.model.base.BaseMultiItem;
import open.cklan.com.library.widget.refresh.anim.AlphaAnimation;
import open.cklan.com.library.widget.refresh.viewholder.BaseViewHolder;

/**
 * AUTHOR：lanchuanke on 17/5/10 18:27
 */
public abstract class BaseAdapter<T,VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {

    private static final int TYPE_EMPTY=1001;
    private static final int TYPE_HEADER=1002;
    private static final int TYPE_FOOTER=1003;
    private static final int TYPE_DEFAULT_ITEM=0;

    private static final int DEFAULT_DURATION=100;//millionSeconds
    protected Context mContext;
    protected List<T> mDatas;
    private View mEmptyView;
    private SparseArray<Integer> layouts;

    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    private OnItemChildClickListener mOnItemChildClickListener;
    private OnItemChildLongClickListener mOnItemChildLongClickListener;
    private boolean mOpenAnimationEnable=false;
    private boolean mFirstOnlyEnable=true;
    private int mLastPosition=-1;
    private BaseAnimation mCustomAnimation=new AlphaAnimation();
    private long mDuration=DEFAULT_DURATION;
    private TimeInterpolator mInterpolator=new LinearInterpolator();


    public BaseAdapter(Context mContext, List<T> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    public void addDefaultItemViewType(@LayoutRes int layoutId){
        addItemViewType(TYPE_DEFAULT_ITEM,layoutId);
    }

    public void addItemViewType(int viewType,@LayoutRes int layoutId){
        if(layouts==null){
            layouts=new SparseArray<>();
        }
        layouts.put(viewType,layoutId);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_EMPTY:
                return createBaseViewHolder(mEmptyView);
            default:
              return createDefaultViewHolder(parent,viewType);
        }
    }

    /**
     * if you want to use subclass of BaseViewHolder in the adapter,
     * you must override the method to create new ViewHolder.
     *
     * @param view view
     * @return new ViewHolder
     */
    @SuppressWarnings("unchecked")
    protected VH createBaseViewHolder(View view) {
        Class temp = getClass();
        Class z = null;
        while (z == null && null != temp) {
            z = getInstancedGenericKClass(temp);
            temp = temp.getSuperclass();
        }
        VH k = createGenericKInstance(z, view);
        return null != k ? k : (VH) new BaseViewHolder(view);
    }

    /**
     * try to create Generic K instance
     *
     * @param z
     * @param view
     * @return
     */
    @SuppressWarnings("unchecked")
    private VH createGenericKInstance(Class z, View view) {
        try {
            Constructor constructor;
            String buffer = Modifier.toString(z.getModifiers());
            String className = z.getName();
            // inner and unstatic class
            if (className.contains("$") && !buffer.contains("static")) {
                constructor = z.getDeclaredConstructor(getClass(), View.class);
                return (VH) constructor.newInstance(this, view);
            } else {
                constructor = z.getDeclaredConstructor(View.class);
                return (VH) constructor.newInstance(view);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get generic parameter K
     *
     * @param z
     * @return
     */
    private Class getInstancedGenericKClass(Class z) {
        Type type = z.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType) type).getActualTypeArguments();
            for (Type temp : types) {
                if (temp instanceof Class) {
                    Class tempClass = (Class) temp;
                    if (BaseViewHolder.class.isAssignableFrom(tempClass)) {
                        return tempClass;
                    }
                }
            }
        }
        return null;
    }

    private VH createDefaultViewHolder(ViewGroup parent, int viewType) {
        if(layouts==null || layouts.size()==0){
            throw new IllegalArgumentException("layouts is empty");
        }
        return createBaseViewHolder(LayoutInflater.from(mContext).inflate(getLayoutId(viewType),parent,false));
    }

    private @LayoutRes int getLayoutId(int viewType){

        return layouts.get(viewType);
    }

    protected abstract void bindData(VH holder,T item,int position);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        int viewType=getItemViewType(position);
        switch (viewType){
            case TYPE_EMPTY:
                break;
            default:
                bindData(holder,mDatas.get(position),position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(getEmptyViewCount()==1){
            return TYPE_EMPTY;
        }else{
            T data=mDatas.get(position);
            if(data instanceof BaseMultiItem){
                return ((BaseMultiItem) data).viewType;
            }
            return TYPE_DEFAULT_ITEM;
        }
    }

    public void setEmptyView(@LayoutRes int layoutId){
        mEmptyView=LayoutInflater.from(mContext).inflate(layoutId,null);
    }

    private int getEmptyViewCount(){
        if(mEmptyView==null){
            return 0;
        }else if(mDatas.size()>=0){
            return 0;
        }
        return 1;
    }


    @Override
    public int getItemCount() {
        if(getEmptyViewCount()==1){
            return 1;
        }else{
           return mDatas.size();
        }
    }

    public T getItem(int position){
        if (position < mDatas.size())
            return mDatas.get(position);
        else
            return null;
    }

    @Override
    public void onViewAttachedToWindow(VH holder) {
        super.onViewAttachedToWindow(holder);
        int viewType=holder.getItemViewType();
        if(viewType==TYPE_EMPTY || viewType==TYPE_FOOTER || viewType== TYPE_HEADER){
            setFullSpan(holder);
        }else{
            addAnimation(holder);
        }
    }

    public void setCustomAnimation(BaseAnimation animation){
        mCustomAnimation=animation;
        mOpenAnimationEnable=true;
    }

    public void setAnimationEnable(boolean enable){
        mOpenAnimationEnable=enable;
    }

    public void setAnimationDuration(int duration){
        mDuration=duration;
    }

    public void setInterpolator(TimeInterpolator interpolator){
        mInterpolator=interpolator;
    }


    private void addAnimation(RecyclerView.ViewHolder holder) {
        if (mOpenAnimationEnable) {
            if (!mFirstOnlyEnable || holder.getLayoutPosition() > mLastPosition) {
                if (mCustomAnimation != null) {
                    for (Animator anim : mCustomAnimation.getAnimators(holder.itemView)) {
                        startAnim(anim, holder.getLayoutPosition());
                    }
                }
                mLastPosition = holder.getLayoutPosition();
            }
        }
    }

    protected void startAnim(Animator anim, int index) {
        anim.setDuration(mDuration).start();
        anim.setInterpolator(mInterpolator);
    }

    protected void setFullSpan(RecyclerView.ViewHolder holder) {
        if (holder.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) holder
                    .itemView.getLayoutParams();
            params.setFullSpan(true);
        }
    }

    /**
     * Interface definition for a callback to be invoked when an itemchild in this
     * view has been clicked
     */
    public interface OnItemChildClickListener {
        /**
         * callback method to be invoked when an item in this view has been
         * click and held
         *
         * @param view     The view whihin the ItemView that was clicked
         * @param position The position of the view int the adapter
         */
        void onItemChildClick(BaseAdapter adapter, View view, int position);
    }


    /**
     * Interface definition for a callback to be invoked when an childView in this
     * view has been clicked and held.
     */
    public interface OnItemChildLongClickListener {
        /**
         * callback method to be invoked when an item in this view has been
         * click and held
         *
         * @param view     The childView whihin the itemView that was clicked and held.
         * @param position The position of the view int the adapter
         * @return true if the callback consumed the long click ,false otherwise
         */
        boolean onItemChildLongClick(BaseAdapter adapter, View view, int position);
    }

    /**
     * Interface definition for a callback to be invoked when an item in this
     * view has been clicked and held.
     */
    public interface OnItemLongClickListener {
        /**
         * callback method to be invoked when an item in this view has been
         * click and held
         *
         * @param adapter  the adpater
         * @param view     The view whihin the RecyclerView that was clicked and held.
         * @param position The position of the view int the adapter
         * @return true if the callback consumed the long click ,false otherwise
         */
        boolean onItemLongClick(BaseAdapter adapter, View view, int position);
    }


    /**
     * Interface definition for a callback to be invoked when an item in this
     * RecyclerView itemView has been clicked.
     */
    public interface OnItemClickListener {

        /**
         * Callback method to be invoked when an item in this RecyclerView has
         * been clicked.
         *
         * @param adapter  the adpater
         * @param view     The itemView within the RecyclerView that was clicked (this
         *                 will be a view provided by the adapter)
         * @param position The position of the view in the adapter.
         */
        void onItemClick(BaseAdapter adapter, View view, int position);
    }

    /**
     * Register a callback to be invoked when an item in this RecyclerView has
     * been clicked.
     *
     * @param listener The callback that will be invoked.
     */
    public void setOnItemClickListener(@Nullable OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    /**
     * Register a callback to be invoked when an itemchild in View has
     * been  clicked
     *
     * @param listener The callback that will run
     */
    public void setOnItemChildClickListener(OnItemChildClickListener listener) {
        mOnItemChildClickListener = listener;
    }

    /**
     * Register a callback to be invoked when an item in this RecyclerView has
     * been long clicked and held
     *
     * @param listener The callback that will run
     */
    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mOnItemLongClickListener = listener;
    }

    /**
     * Register a callback to be invoked when an itemchild  in this View has
     * been long clicked and held
     *
     * @param listener The callback that will run
     */
    public void setOnItemChildLongClickListener(OnItemChildLongClickListener listener) {
        mOnItemChildLongClickListener = listener;
    }


    /**
     * @return The callback to be invoked with an item in this RecyclerView has
     * been long clicked and held, or null id no callback as been set.
     */
    public final OnItemLongClickListener getOnItemLongClickListener() {
        return mOnItemLongClickListener;
    }

    /**
     * @return The callback to be invoked with an item in this RecyclerView has
     * been clicked and held, or null id no callback as been set.
     */
    public final OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    /**
     * @return The callback to be invoked with an itemchild in this RecyclerView has
     * been clicked, or null id no callback has been set.
     */
    @Nullable
    public final OnItemChildClickListener getOnItemChildClickListener() {
        return mOnItemChildClickListener;
    }

    /**
     * @return The callback to be invoked with an itemChild in this RecyclerView has
     * been long clicked, or null id no callback has been set.
     */
    @Nullable
    public final OnItemChildLongClickListener getOnItemChildLongClickListener() {
        return mOnItemChildLongClickListener;
    }

    public interface BaseAnimation{
        Animator[] getAnimators(View view);
    }
}
