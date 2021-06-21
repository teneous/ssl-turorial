/*
 *  Copyright (C), 2008-2021, Syoka All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.syoka.practical.itinerary.infrastructure.common;

import lombok.Data;

/**
 * 通用返回
 *
 * @author syoka
 * @version : Result.java 2021年05月12日 10时07分
 */
@Data
public class Result<T> {

    private String code;
    private String msg;
    private T data;
    private String timestamp;

    private Result() {
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode("200");
        result.setCode("success");
        result.setData(data);
        result.setTimestamp(String.valueOf(System.currentTimeMillis()));
        return result;
    }


}

