package service.directory.get_use_case;

import controller.directory.get_use_case.GetDirectoryService;
import dto.directory.DirectoryDto;
import dto.directory.EntityDto;
import dto.directory.ItemDto;
import lombok.RequiredArgsConstructor;
import model.directory.Directory;
import model.directory.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import service.mapper.Mapper;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class GetDirectoryServiceImpl implements GetDirectoryService {
    private final GetDirectoryRepository directoryRepository;
    private final GetItemRepository itemRepository;

    private final Mapper<DirectoryDto, Directory> directoryMapper;
    private final Mapper<ItemDto, Item> itemMapper;

    @Override
    public Page<EntityDto> getUserRootDirectoryContent(String username, Pageable pageable) {
        double directorySize = Math.ceil(pageable.getPageSize() / 2d);
        double itemSize = Math.floor(pageable.getPageSize() / 2d);

        Page<Directory> directories = directoryRepository.getAllByUpperIdAndUsername(
                directoryRepository.getRootUpperId(),
                username,
                PageRequest.of(pageable.getPageNumber(), (int) directorySize)
        );

        Page<Item> items = itemRepository.getAllByDirectoryIdAndUsername(
                directoryRepository.getRootUpperId(),
                username,
                PageRequest.of(pageable.getPageNumber(), (int) itemSize)
        );

        List<EntityDto> entityDtos = Stream.concat(
                directories.getContent().stream().map(directoryMapper::toDto),
                items.getContent().stream().map(itemMapper::toDto)
        ).toList();

        return new PageImpl<>(entityDtos, pageable, entityDtos.size());
    }

    @Override
    public Page<EntityDto> getUserDirectoryByIdContent(String username, Long id, Pageable pageable) {
        double directorySize = Math.ceil(pageable.getPageSize() / 2d);
        double itemSize = Math.floor(pageable.getPageSize() / 2d);

        Page<Directory> directories = directoryRepository.getAllByUpperId(
                id,
                PageRequest.of(pageable.getPageNumber(), (int) directorySize)
        );

        Page<Item> items = itemRepository.getAllByDirectoryId(
                id,
                PageRequest.of(pageable.getPageNumber(), (int) itemSize)
        );

        List<EntityDto> entityDtos = Stream.concat(
                directories.getContent().stream().map(directoryMapper::toDto),
                items.getContent().stream().map(itemMapper::toDto)
        ).toList();

        return new PageImpl<>(entityDtos, pageable, entityDtos.size());
    }
}