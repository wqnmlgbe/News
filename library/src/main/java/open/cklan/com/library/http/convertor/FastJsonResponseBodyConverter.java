/*
 * Copyright (c) 2016 ShenBianVip, Ltd.
 * Unauthorized copying of this file, via any medium is strictly prohibited proprietary and
 *  confidential.
 * Created on 1/5/16 4:00 PM
 * ProjectName: shenbian_android_cloud_speaker ; ModuleName: CSpeakerPhone ; ClassName: FastJsonResponseBodyConverter.
 * Author: Lena; Last Modified: 1/5/16 4:00 PM.
 *  This file is originally created by Lena.
 */

package open.cklan.com.library.http.convertor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.List;

import open.cklan.com.library.model.NewsContentEntity;
import open.cklan.com.library.model.NewsDetailEntity;
import open.cklan.com.library.model.NewsListEntity;
import open.cklan.com.library.utils.LogUtil;
import retrofit.Converter;

public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private Type type;


    public FastJsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String jsonString = new String(value.bytes(), UTF_8);
        try {
            LogUtil.i("Parse Response Json :\n" + jsonString);
            return JSON.parseObject(jsonString, type,processor);
        } catch (Exception e) {
            return (T)jsonString;
        }
    }

    ExtraProcessor processor = new ExtraProcessor() {
        public void processExtra(Object object, String key, Object value) {
            if(object!=null && object instanceof NewsListEntity){
                NewsListEntity vo = (NewsListEntity) object;
                if(value!=null && value instanceof JSONArray){
                    JSONArray array= (JSONArray) value;
                    if(type!=null && type instanceof ParameterizedType){
                        Type[] generics = ((ParameterizedType) type).getActualTypeArguments();
                        if(generics.length==1){
                           vo.entities=JSON.parseArray(array.toString(),(Class<?>)generics[0]);
                        }
                    }
                }
            }else if(object!=null && object instanceof NewsDetailEntity){
                NewsDetailEntity vo= (NewsDetailEntity) object;
                if(value!=null && value instanceof JSONObject){
                    vo.entity=JSON.parseObject(value.toString(),NewsContentEntity.class);
                }
            }
        }
    };
}
