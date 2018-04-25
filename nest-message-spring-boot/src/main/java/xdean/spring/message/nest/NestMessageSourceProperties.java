package xdean.spring.message.nest;

import lombok.Data;
import xdean.codecov.CodecovIgnore;

@Data
@CodecovIgnore
public class NestMessageSourceProperties {
  String prefix = "$(";
  String suffix = ")";
  String splitor = ",";
  String argPrefix = "$";
  String escaper = "\\";
  String quoter = "\"";
}
