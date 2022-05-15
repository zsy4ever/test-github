package com.zsl.homestay.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.util.FileUtils;

@Component
public class MyStringImageConverter implements Converter<String> {

	@Value("${file.patch}")
	private String filePatch;

	@Override
	public Class supportJavaTypeKey() {
		return String.class;
	}

	@Override
	public CellDataTypeEnum supportExcelTypeKey() {
		return CellDataTypeEnum.IMAGE;
	}

	@Override
	public String convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
			GlobalConfiguration globalConfiguration) {
		throw new UnsupportedOperationException("Cannot convert images to string");
	}

	// 图片失效处理
	@Override
	public CellData convertToExcelData(String value, ExcelContentProperty contentProperty,
			GlobalConfiguration globalConfiguration) throws IOException {
		File file = new File(filePatch + value);
		if (file.exists()) {
			// 文件存在
			return new CellData(FileUtils.readFileToByteArray(new File(value)));
		}
		// 直接返回文字描述
		// FileUtils.readFileToByteArray(new File("/home/test.jpg"))
		return new CellData("无法加载图片");
	}
}