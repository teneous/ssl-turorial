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
package com.syoka.practical.cargo.interfaces.asselbler;

import com.syoka.practical.cargo.domain.cargo.model.Cargo;
import com.syoka.practical.cargo.interfaces.dto.CargoDTO;

/**
 * @author syoka
 * @version : CargoAssembler.java 2021年05月31日 18时17分
 */
public class CargoAssembler {

    /**
     * dto->do
     *
     * @param cargoDTO cargoDto
     * @return Cargo
     */
    public static Cargo toCargo(CargoDTO cargoDTO) {
        Cargo cargo = new Cargo();
        cargo.setDepartureCity(cargoDTO.getOrigin());
        cargo.setArrivalCity(cargoDTO.getDestination());

        cargo.setDeadline(cargoDTO.getDeadLine());
        return cargo;
    }
}
