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
package com.syoka.practical.cargo.interfaces.facade;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.syoka.practical.cargo.application.CargoApplicationService;
import com.syoka.practical.cargo.interfaces.asselbler.CargoAssembler;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import com.syoka.practical.cargo.infrastructure.common.Result;
import com.syoka.practical.cargo.interfaces.dto.CargoDTO;

/**
 * @author syoka
 * @version : CargoFacade.java 2021年05月31日 18时17分
 */
@RestController
@RequiredArgsConstructor
public class CargoFacade {

    @NonNull
    private final CargoApplicationService cargoApplicationService;

    @PostMapping("/cargo")
    public ResponseEntity<Result<String>> booking(@RequestBody CargoDTO cargoDTO) {
        String trackingId = cargoApplicationService.booking(CargoAssembler.toCargo(cargoDTO));
        return ResponseEntity.ok(Result.success(trackingId));
    }

    /**
     * 心跳测试
     */
    @GetMapping("/heartbeat")
    public ResponseEntity<Result<String>> heartBeating() {
        return ResponseEntity.ok(Result.success());
    }
}
