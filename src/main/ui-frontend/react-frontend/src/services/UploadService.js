import http from "../http-common";

const UPLOAD_REST_API_URL = 'http://localhost:8080/api/upload';
const FILES_REST_API_URL = 'http://localhost:8080/api/files';

class UploadFilesService {
  upload(file, onUploadProgress) {
    let formData = new FormData();

    formData.append("file", file);

    var output =  http.post(UPLOAD_REST_API_URL, formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
      onUploadProgress,
    });

    return output;
  }

  getFiles() {
    return http.get(FILES_REST_API_URL);
  }
}

export default new UploadFilesService();