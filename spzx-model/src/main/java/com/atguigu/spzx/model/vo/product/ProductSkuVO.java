package com.atguigu.spzx.model.vo.product;

import com.atguigu.spzx.model.entity.base.BaseEntity;
import com.atguigu.spzx.model.entity.product.ProductSku;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Schema(description = "ProductSkuVO")
public class ProductSkuVO {

	@Schema(description = "商品编号")
	private Long sukId;

	@Schema(description = "skuName")
	private String skuName;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "缩略图路径")
	private String thumbImg;

	@Schema(description = "售价")
	private BigDecimal salePrice;

}