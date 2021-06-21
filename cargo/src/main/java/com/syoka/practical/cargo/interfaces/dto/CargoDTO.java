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
package com.syoka.practical.cargo.interfaces.dto;

import lombok.Data;

/**
 * @author syoka
 * @version : CargoDTO.java 2021年06月18日 22时49分
 */
@Data
public class CargoDTO {
    /**
     * 截止日期
     */
    private String deadLine;
    /**
     * 起始地
     */
    private String origin;
    /**
     * 终点
     */
    private String destination;
}