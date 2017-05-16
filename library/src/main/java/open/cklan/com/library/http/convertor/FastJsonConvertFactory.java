/*
 * Copyright (c) 2016 ShenBianVip, Ltd.
 * Unauthorized copying of this file, via any medium is strictly prohibited proprietary and
 *  confidential.
 * Created on 1/5/16 4:00 PM
 * ProjectName: shenbian_android_cloud_speaker ; ModuleName: CSpeakerPhone ; ClassName: FastJsonConvertFactory.
 * Author: Lena; Last Modified: 1/5/16 4:00 PM.
 *  This file is originally created by Lena.
 */

package open.cklan.com.library.http.convertor;

import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit.Converter;


public class FastJsonConvertFactory extends Converter.Factory{

    public static FastJsonConvertFactory create() {
       return new FastJsonConvertFactory();
    }

    @Override
    public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
        return new FastJsonResponseBodyConverter<>(type);
    }

    @Override
    public Converter<?, RequestBody> toRequestBody(Type type, Annotation[] annotations) {
        return new FastJsonRequestBodyConvert<>();
    }
}
