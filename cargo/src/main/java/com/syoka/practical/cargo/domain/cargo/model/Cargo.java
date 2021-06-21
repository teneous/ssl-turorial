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
package com.syoka.practical.cargo.domain.cargo.model;

import lombok.Data;

/**
 * Cargo entity
 *
 * @author syoka
 * @version : Cargo.java 2021年05月31日 16时46分
 */
@Data
public class Cargo {

    /**
     * 起始日期
     */
    private String departureDate;
    /**
     * 到达日期
     */
    private String arrivalDate;
    /**
     * 截止日
     */
    private String deadline;
    /**
     * 起点
     */
    private String departureCity;
    /**
     * 终点
     */
    private String arrivalCity;
}
