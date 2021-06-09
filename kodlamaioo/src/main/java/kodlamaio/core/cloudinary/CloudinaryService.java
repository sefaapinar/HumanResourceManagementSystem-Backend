package kodlamaio.core.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.core.utilities.DataResult;

public interface CloudinaryService {

	DataResult<?> save(MultipartFile file);
}
