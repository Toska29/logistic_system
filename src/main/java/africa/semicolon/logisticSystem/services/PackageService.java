package africa.semicolon.logisticSystem.services;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.dtos.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.dtos.responses.AddPackageResponse;

public interface PackageService {

    AddPackageResponse addPackage(AddPackageRequest addPackageRequest);

    Package findMyPackageWithMy(Integer id);
}
