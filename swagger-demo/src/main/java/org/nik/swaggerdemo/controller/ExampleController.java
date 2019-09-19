package org.nik.swaggerdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.nik.swaggerdemo.model.DummyResponse;
import org.nik.swaggerdemo.service.ExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="Dummy Swagger API", tags = "dummy-swagger-api")
public class ExampleController {

    private ExampleService exampleService;

    @ApiOperation(value = "Getting dummy by dummyId", tags = "get-dummy")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Dummy response"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/dummy/{dummyId}")
    public DummyResponse getDummy(@ApiParam(value = "Path Variable as dummyId") @PathVariable Integer dummyId){
        return exampleService.getDummy(dummyId);
    }
}
