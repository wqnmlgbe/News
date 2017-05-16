/*
 * Copyright (c) 2016 ShenBianVip, Ltd.
 * Unauthorized copying of this file, via any medium is strictly prohibited proprietary and
 *  confidential.
 * Created on 1/5/16 4:00 PM
 * ProjectName: shenbian_android_cloud_speaker ; ModuleName: CSpeakerPhone ; ClassName: FastJsonRequestBodyConvert.
 * Author: Lena; Last Modified: 1/5/16 4:00 PM.
 *  This file is originally created by Lena.
 */

package open.cklan.com.library.http.convertor;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;
import java.nio.charset.Charset;

import open.cklan.com.library.utils.LogUtil;
import retrofit.Converter;

public class FastJsonRequestBodyConvert<T> implements Converter<T, RequestBody> {

    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

    @Override
    public RequestBody convert(T value) throws IOException {
        String postBody = JSON.toJSONString(value);
        LogUtil.i("Post Json Body " + new String(postBody.getBytes(),UTF_8));
        return RequestBody.create(MEDIA_TYPE, postBody.getBytes(UTF_8));
    }
}
