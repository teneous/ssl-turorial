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
package com.syoka.practical.cargo.domain.cargo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.syoka.practical.cargo.domain.cargo.model.Cargo;
import com.syoka.practical.cargo.domain.cargo.model.CargoSpecification;
import com.syoka.practical.cargo.domain.cargo.model.Itinerary;
import com.syoka.practical.cargo.domain.cargo.model.ItinerarySpecification;
import com.syoka.practical.cargo.domain.cargo.service.CargoDomainService;
import com.syoka.practical.cargo.domain.cargo.service.ItineraryService;

/**
 * @author syoka
 * @version : CargoDomainServiceImpl.java 2021年06月18日 22时56分
 */
@Service
public class CargoDomainServiceImpl implements CargoDomainService {

    /**
     * 航线服务--->领域只做接口声明，实现由基础设施实现（DPI）
     */
    private final ItineraryService itineraryService;
    private final ItinerarySpecification itinerarySpecification;

    private static final String NON_EXISTS = "-1";

    public CargoDomainServiceImpl(ItineraryService itineraryService, ItinerarySpecification itinerarySpecification) {
        this.itineraryService = itineraryService;
        this.itinerarySpecification = itinerarySpecification;
    }

    @Override
    public String booking(Cargo cargo) {
        CargoSpecification specification = new CargoSpecification(cargo);
        //获取所有货运公司的货运表
        List<Itinerary> itinerary = itineraryService.getItinerary(specification);
        //选择耗时最短
        Itinerary evaluate = itinerarySpecification.evaluate(itinerary);

        String trackingId = NON_EXISTS;
        if (evaluate != null) {
            trackingId = String.format("%s:%s", evaluate.getSupplier(), UUID.randomUUID().toString().replace("-", ""));
        }
        return trackingId;
    }
}