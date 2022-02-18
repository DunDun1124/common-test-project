package cute.dundun.entity.types;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Page {
  private Integer pageCurrent;

  private Integer pageSize;

  public Page() {
  }

  public Page(Integer pageCurrent, Integer pageSize) {
    this.pageCurrent = pageCurrent;
    this.pageSize = pageSize;
  }

  public Integer getPageCurrent() {
    return pageCurrent;
  }

  public void setPageCurrent(Integer pageCurrent) {
    this.pageCurrent = pageCurrent;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public String toString() {
    return "{" + "pageCurrent:" + pageCurrent + "," +"pageSize:" + pageSize + "" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page that = (Page) o;
        return java.util.Objects.equals(pageCurrent, that.pageCurrent) &&
                            java.util.Objects.equals(pageSize, that.pageSize);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(pageCurrent, pageSize);
  }

  public static cute.dundun.entity.types.Page.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private Integer pageCurrent;

    private Integer pageSize;

    public Page build() {
                  cute.dundun.entity.types.Page result = new cute.dundun.entity.types.Page();
                      result.pageCurrent = this.pageCurrent;
          result.pageSize = this.pageSize;
                      return result;
    }

    public cute.dundun.entity.types.Page.Builder pageCurrent(Integer pageCurrent) {
      this.pageCurrent = pageCurrent;
      return this;
    }

    public cute.dundun.entity.types.Page.Builder pageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }
  }
}
