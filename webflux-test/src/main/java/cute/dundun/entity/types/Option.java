package cute.dundun.entity.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Option {
  private String label;

  private String value;

  public Option() {
  }

  public Option(String label, String value) {
    this.label = label;
    this.value = value;
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

  @Override
  public String toString() {
    return "Option{" + "label='" + label + "'," +"value='" + value + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option that = (Option) o;
        return java.util.Objects.equals(label, that.label) &&
                            java.util.Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(label, value);
  }

  public static cute.dundun.entity.types.Option.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String label;

    private String value;

    public Option build() {
                  cute.dundun.entity.types.Option result = new cute.dundun.entity.types.Option();
                      result.label = this.label;
          result.value = this.value;
                      return result;
    }

    public cute.dundun.entity.types.Option.Builder label(String label) {
      this.label = label;
      return this;
    }

    public cute.dundun.entity.types.Option.Builder value(String value) {
      this.value = value;
      return this;
    }
  }
}
