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
package com.syoka.practical.feign.cargo.application;

import com.syoka.practical.feign.cargo.domain.cargo.model.Cargo;
import com.syoka.practical.feign.cargo.domain.cargo.service.CargoDomainService;

/**
 * @author syoka
 * @version : CargoApplicationService.java 2021年05月31日 16时39分
 */
public class CargoApplicationService {

    private final CargoDomainService cargoDomainService;

    public CargoApplicationService(CargoDomainService cargoDomainService) {
        this.cargoDomainService = cargoDomainService;
    }

    /**
     * Booking cargo
     */
    public String booking(Cargo cargo) {
        return cargoDomainService.booking(cargo);
    }
}
