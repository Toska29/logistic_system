package africa.semicolon.logisticSystem.controllers;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.dtos.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.dtos.responses.AddPackageResponse;
import africa.semicolon.logisticSystem.services.PackageService;
import africa.semicolon.logisticSystem.services.PackageServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageController {
    private PackageService packageService = new PackageServiceImpl();

    @PostMapping("/api/addpackage")
    public AddPackageResponse addPackage(@RequestBody AddPackageRequest addPackageRequest){
        return packageService.addPackage(addPackageRequest);
    }

    @GetMapping("/api/package/{id}")
    public Package findPackageById(@PathVariable("id") Integer id){
        return packageService.findMyPackageWithMy(id);
    }
}
