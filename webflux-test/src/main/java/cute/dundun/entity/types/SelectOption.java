package cute.dundun.entity.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class SelectOption {
  private String label;

  private String value;

  private List<SelectOption> child;

  public SelectOption() {
  }

  public SelectOption(String label, String value, List<SelectOption> child) {
    this.label = label;
    this.value = value;
    this.child = child;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public List<SelectOption> getChild() {
    return child;
  }

  public void setChild(List<SelectOption> child) {
    this.child = child;
  }

  @Override
  public String toString() {
    return "SelectOption{" + "label='" + label + "'," +"value='" + value + "'," +"child='" + child + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectOption that = (SelectOption) o;
        return java.util.Objects.equals(label, that.label) &&
                            java.util.Objects.equals(value, that.value) &&
                            java.util.Objects.equals(child, that.child);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(label, value, child);
  }

  public static cute.dundun.entity.types.SelectOption.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String label;

    private String value;

    private List<SelectOption> child;

    public SelectOption build() {
                  cute.dundun.entity.types.SelectOption result = new cute.dundun.entity.types.SelectOption();
                      result.label = this.label;
          result.value = this.value;
          result.child = this.child;
                      return result;
    }

    public cute.dundun.entity.types.SelectOption.Builder label(String label) {
      this.label = label;
      return this;
    }

    public cute.dundun.entity.types.SelectOption.Builder value(String value) {
      this.value = value;
      return this;
    }

    public cute.dundun.entity.types.SelectOption.Builder child(List<SelectOption> child) {
      this.child = child;
      return this;
    }
  }
}
