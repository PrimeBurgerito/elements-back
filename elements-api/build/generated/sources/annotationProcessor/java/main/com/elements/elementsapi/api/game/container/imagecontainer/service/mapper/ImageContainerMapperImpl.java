package com.elements.elementsapi.api.game.container.imagecontainer.service.mapper;

import com.elements.elementsapi.api.game.container.imagecontainer.service.resource.ImageContainerDto;
import com.elements.elementsapi.api.shared.service.resource.ImageDto;
import com.elements.elementsapi.api.shared.service.resource.ImageDto.ImageDtoBuilder;
import com.elements.elementsdomain.document.container.ImageContainer;
import com.elements.elementsdomain.document.container.ImageContainer.ImageContainerBuilder;
import com.elements.elementsdomain.shared.image.Image;
import com.elements.elementsdomain.shared.image.Image.ImageBuilder;
import com.elements.elementsdomain.shared.image.ImageCrop;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-30T17:10:22+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.9.1.jar, environment: Java 13 (Oracle Corporation)"
)
@Component
public class ImageContainerMapperImpl implements ImageContainerMapper {

    @Override
    public ImageContainerDto map(ImageContainer document) {
        if ( document == null ) {
            return null;
        }

        ImageContainerDto imageContainerDto = new ImageContainerDto();

        imageContainerDto.setRealmId( document.getRealmId() );
        imageContainerDto.setKey( document.getKey() );
        imageContainerDto.setImages( imageSetToImageDtoSet( document.getImages() ) );

        return imageContainerDto;
    }

    @Override
    public List<ImageContainerDto> map(Collection<ImageContainer> documents) {
        if ( documents == null ) {
            return null;
        }

        List<ImageContainerDto> list = new ArrayList<ImageContainerDto>( documents.size() );
        for ( ImageContainer imageContainer : documents ) {
            list.add( map( imageContainer ) );
        }

        return list;
    }

    @Override
    public ImageContainer map(ImageContainerDto documentDto) {
        if ( documentDto == null ) {
            return null;
        }

        ImageContainerBuilder<?, ?> imageContainer = ImageContainer.builder();

        imageContainer.realmId( documentDto.getRealmId() );
        imageContainer.key( documentDto.getKey() );
        imageContainer.images( imageDtoSetToImageSet( documentDto.getImages() ) );

        return imageContainer.build();
    }

    @Override
    public void update(ImageContainerDto dto, ImageContainer document) {
        if ( dto == null ) {
            return;
        }

        document.setRealmId( dto.getRealmId() );
        document.setKey( dto.getKey() );
        if ( document.getImages() != null ) {
            Set<Image> set = imageDtoSetToImageSet( dto.getImages() );
            if ( set != null ) {
                document.getImages().clear();
                document.getImages().addAll( set );
            }
            else {
                document.setImages( null );
            }
        }
        else {
            Set<Image> set = imageDtoSetToImageSet( dto.getImages() );
            if ( set != null ) {
                document.setImages( set );
            }
        }
    }

    protected ImageDto imageToImageDto(Image image) {
        if ( image == null ) {
            return null;
        }

        ImageDtoBuilder imageDto = ImageDto.builder();

        Map<String, ImageCrop> map = image.getCrops();
        if ( map != null ) {
            imageDto.crops( new HashMap<String, ImageCrop>( map ) );
        }

        return imageDto.build();
    }

    protected Set<ImageDto> imageSetToImageDtoSet(Set<Image> set) {
        if ( set == null ) {
            return null;
        }

        Set<ImageDto> set1 = new HashSet<ImageDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Image image : set ) {
            set1.add( imageToImageDto( image ) );
        }

        return set1;
    }

    protected Image imageDtoToImage(ImageDto imageDto) {
        if ( imageDto == null ) {
            return null;
        }

        ImageBuilder image = Image.builder();

        Map<String, ImageCrop> map = imageDto.getCrops();
        if ( map != null ) {
            image.crops( new HashMap<String, ImageCrop>( map ) );
        }

        return image.build();
    }

    protected Set<Image> imageDtoSetToImageSet(Set<ImageDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Image> set1 = new HashSet<Image>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ImageDto imageDto : set ) {
            set1.add( imageDtoToImage( imageDto ) );
        }

        return set1;
    }
}
