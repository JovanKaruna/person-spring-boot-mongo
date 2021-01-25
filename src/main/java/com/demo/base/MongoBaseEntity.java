package com.demo.base;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "superBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class MongoBaseEntity implements Serializable {

	public static final String FIELD_ID = "id";
	public static final String FIELD_MARK_FOR_DELETE = "markForDelete";
	public static final String FIELD_VERSION = "version";
	public static final String FIELD_CREATED_BY = "createdBy";
	public static final String FIELD_CREATED_DATE = "createdDate";
	public static final String FIELD_UPDATED_BY = "updatedBy";
	public static final String FIELD_UPDATED_DATE = "updatedDate";
	public static final String FIELD_STORE_ID = "storeId";

	@Id
	@Field(value = MongoBaseEntity.FIELD_ID)
	private String id;

	@Field(value = MongoBaseEntity.FIELD_MARK_FOR_DELETE)
	@Builder.Default
	private boolean markForDelete = false;

	@Field(value = MongoBaseEntity.FIELD_VERSION)
	@Builder.Default
	private Long version = 0L;

	@CreatedBy
	@Field(value = MongoBaseEntity.FIELD_CREATED_BY)
	private String createdBy;

	@CreatedDate
	@Field(value = MongoBaseEntity.FIELD_CREATED_DATE)
	private Date createdDate;

	@LastModifiedBy
	@Field(value = MongoBaseEntity.FIELD_UPDATED_BY)
	private String updatedBy;

	@LastModifiedDate
	@Field(value = MongoBaseEntity.FIELD_UPDATED_DATE)
	private Date updatedDate;

	@Field(value = MongoBaseEntity.FIELD_STORE_ID)
	private String storeId;

}
