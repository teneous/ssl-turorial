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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.syoka.practical.cargo.domain.shared.Specification;

import lombok.Data;

/**
 * @author syoka
 * @version : CargoSpecification.java 2021年06月18日 23时17分
 */
@Data
public class CargoSpecification implements Specification {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private String origin;

    private String destination;

    private String deadline;

    private String sailTime;

    public CargoSpecification() {
    }

    public CargoSpecification(Cargo cargo) {
        CargoSpecification specification = new CargoSpecification();
        specification.setOrigin(cargo.getDepartureCity());
        specification.setDestination(cargo.getArrivalCity());
        specification.setSailTime(cargo.getDepartureDate() == null ? FORMATTER.format(LocalDateTime.now()) : cargo.getDepartureDate());
        specification.setDeadline(cargo.getDeadline());
    }
}