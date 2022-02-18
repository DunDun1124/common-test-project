package cute.dundun.entity.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class FilePayload {
  private String fileId;

  private String filename;

  private String fileUrl;

  private String fileUploadTime;

  public FilePayload() {
  }

  public FilePayload(String fileId, String filename, String fileUrl, String fileUploadTime) {
    this.fileId = fileId;
    this.filename = filename;
    this.fileUrl = fileUrl;
    this.fileUploadTime = fileUploadTime;
  }

  public String getFileId() {
    return fileId;
  }

  public void setFileId(String fileId) {
    this.fileId = fileId;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getFileUrl() {
    return fileUrl;
  }

  public void setFileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
  }

  public String getFileUploadTime() {
    return fileUploadTime;
  }

  public void setFileUploadTime(String fileUploadTime) {
    this.fileUploadTime = fileUploadTime;
  }

  @Override
  public String toString() {
    return "FilePayload{" + "fileId='" + fileId + "'," +"filename='" + filename + "'," +"fileUrl='" + fileUrl + "'," +"fileUploadTime='" + fileUploadTime + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilePayload that = (FilePayload) o;
        return java.util.Objects.equals(fileId, that.fileId) &&
                            java.util.Objects.equals(filename, that.filename) &&
                            java.util.Objects.equals(fileUrl, that.fileUrl) &&
                            java.util.Objects.equals(fileUploadTime, that.fileUploadTime);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(fileId, filename, fileUrl, fileUploadTime);
  }

  public static cute.dundun.entity.types.FilePayload.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String fileId;

    private String filename;

    private String fileUrl;

    private String fileUploadTime;

    public FilePayload build() {
                  cute.dundun.entity.types.FilePayload result = new cute.dundun.entity.types.FilePayload();
                      result.fileId = this.fileId;
          result.filename = this.filename;
          result.fileUrl = this.fileUrl;
          result.fileUploadTime = this.fileUploadTime;
                      return result;
    }

    public cute.dundun.entity.types.FilePayload.Builder fileId(String fileId) {
      this.fileId = fileId;
      return this;
    }

    public cute.dundun.entity.types.FilePayload.Builder filename(String filename) {
      this.filename = filename;
      return this;
    }

    public cute.dundun.entity.types.FilePayload.Builder fileUrl(String fileUrl) {
      this.fileUrl = fileUrl;
      return this;
    }

    public cute.dundun.entity.types.FilePayload.Builder fileUploadTime(String fileUploadTime) {
      this.fileUploadTime = fileUploadTime;
      return this;
    }
  }
}
