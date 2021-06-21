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
package com.syoka.practical.itinerary.domain.itinerary.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.syoka.practical.itinerary.api.dto.ItineraryPlan;

/**
 * @author syoka
 * @version : ItineraryFactoryService.java 2021年05月12日 13时36分
 */
@Service
public class ItineraryFactoryService {


    public ItineraryPlan create(Company company) {
        ItineraryPlan itineraryPlan = new ItineraryPlan();
        itineraryPlan.setSupplier(company.name());
        itineraryPlan.setCostTime(new Random().nextInt(1000));
        return itineraryPlan;
    }

    public enum Company {
        /**
         * 远图
         */
        FURETHEMORE,
        /**
         * 北极星
         */
        POLESTART
    }
}
