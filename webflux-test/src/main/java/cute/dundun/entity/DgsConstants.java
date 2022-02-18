package cute.dundun.entity;

import java.lang.String;

public class DgsConstants {
  public static final String QUERY_TYPE = "Query";

  public static class OPTION {
    public static final String TYPE_NAME = "Option";

    public static final String Label = "label";

    public static final String Value = "value";
  }

  public static class SELECTOPTION {
    public static final String TYPE_NAME = "SelectOption";

    public static final String Label = "label";

    public static final String Value = "value";

    public static final String Child = "child";
  }

  public static class FILEPAYLOAD {
    public static final String TYPE_NAME = "FilePayload";

    public static final String FileId = "fileId";

    public static final String Filename = "filename";

    public static final String FileUrl = "fileUrl";

    public static final String FileUploadTime = "fileUploadTime";
  }

  public static class QUERY {
    public static final String TYPE_NAME = "Query";

    public static final String TestFilter = "testFilter";
  }

  public static class PAGE {
    public static final String TYPE_NAME = "Page";

    public static final String PageCurrent = "pageCurrent";

    public static final String PageSize = "pageSize";
  }

  public static class FILEINPUT {
    public static final String TYPE_NAME = "FileInput";

    public static final String FileId = "fileId";

    public static final String Filename = "filename";

    public static final String FileUrl = "fileUrl";

    public static final String FileUploadTime = "fileUploadTime";
  }
}
