package africa.semicolon.logisticSystem.services;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.data.repositories.PackageRepository;
import africa.semicolon.logisticSystem.data.repositories.PackageRepositoryImpl;
import africa.semicolon.logisticSystem.dtos.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.dtos.responses.AddPackageResponse;
import africa.semicolon.logisticSystem.utils.ModelMapper;

public class PackageServiceImpl implements PackageService {
    private final PackageRepository packageRepository = new PackageRepositoryImpl();

    @Override
    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest) {
        //convert addPackage request to a package
        Package aPackage = ModelMapper.map(addPackageRequest);

        //save package
        Package savedPackage = packageRepository.save(aPackage);

        //convert saved package to addPackage response
        AddPackageResponse response = ModelMapper.map(savedPackage);
        //return converted response
        return  response;
    }

    @Override
    public Package findMyPackageWithMy(Integer id) {
        return packageRepository.findPackageById(id);
    }
}
