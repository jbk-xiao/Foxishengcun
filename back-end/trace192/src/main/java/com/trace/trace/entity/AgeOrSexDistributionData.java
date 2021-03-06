package com.trace.trace.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * 年龄或性别分布返回值中列表内的每个数据。（复用）
 */
@Data
public class AgeOrSexDistributionData {
    @Expose(serialize = false, deserialize = false)
    private String period;
    @Expose
    @SerializedName("range")
    private String range;
    @Expose
    @SerializedName("tgi")
    private Double tgi;
    @Expose
    @SerializedName("word_rate")
    private Double wordRate;
    @Expose
    @SerializedName("all_rate")
    private Double allRate;
}
