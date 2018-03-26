
package com.store.serviceImpl;

        import com.store.entity.ClothesBrand;
        import com.store.repository.ClothesBrandRepository;
        import com.store.service.ClothesBrandService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.Optional;

@Service
public class ClothesBrandServiceImpl implements ClothesBrandService {

    private final ClothesBrandRepository clothesBrandRepository;
    @Autowired
    public ClothesBrandServiceImpl(ClothesBrandRepository clothesBrandRepository){
        this.clothesBrandRepository = clothesBrandRepository;
    }
    @Override
    public Iterable<ClothesBrand> findAll(){
        return clothesBrandRepository.findAll();
    }
    @Override
    public Optional<ClothesBrand> findOne(Long id){
        return clothesBrandRepository.findById(id);
    }
    @Override
    public ClothesBrand save(ClothesBrand brand){
        return  clothesBrandRepository.save(brand);
    }
    @Override
    public void delete(Long id){
        clothesBrandRepository.deleteById(id);
    }
}