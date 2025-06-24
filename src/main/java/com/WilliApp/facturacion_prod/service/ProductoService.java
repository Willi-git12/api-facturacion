package com.WilliApp.facturacion_prod.service;

import com.WilliApp.facturacion_prod.dto.ProductoDTO;
import com.WilliApp.facturacion_prod.model.Producto;
import com.WilliApp.facturacion_prod.repository.ProductoRepository;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;

    public ProductoService(ProductoRepository productoRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
    }

    //Save
    public ProductoDTO save (ProductoDTO productoDTO){
        Producto producto = modelMapper.map(productoDTO, Producto.class);

        return modelMapper.map( productoRepository.save(producto), ProductoDTO.class);
    }

    //Find all
    public List<ProductoDTO> finAll (){
        return productoRepository.findAll().stream().map(
                producto -> {
                    return modelMapper.map(producto, ProductoDTO.class);
                }
        ).collect(Collectors.toList());
    }

    //Find by Id
    public Optional<ProductoDTO> finById(Integer id){
        return productoRepository.findById(id).map(
                producto -> {
                    return modelMapper.map(producto, ProductoDTO.class);
                }
        );
    }

    //Delete by Id
    public boolean deleteById(Integer id){
        return productoRepository.findById(id).map(
                producto -> {
                    productoRepository.delete(producto);
                    return true;
                }
        ).orElse(false);
    }

    //Update by Id
    public Optional<ProductoDTO> update(ProductoDTO productoDTO){
        Producto producto = modelMapper.map(productoDTO, Producto.class);

        return productoRepository.findById(producto.getId()).map(
                productoDB -> {
                    return modelMapper.map(productoRepository.save(producto), ProductoDTO.class);
                }
        );
    }


}
