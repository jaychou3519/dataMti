package utils;

import utils.def.FtlDef;
import utils.factory.CodeGenerateFactory;




public class CodeGeneration {
	
	public static void main(String[] args) {
		 /** 此处修改成你的 表名 和 中文注释***/
		 String tableName="testaa"; //
		 String codeName ="生产计划";//中文注释  当然你用英文也是可以的 
		 String entityPackage ="testaa";//实体包
		 String keyType = FtlDef.KEY_TYPE_01;//主键生成方式 01:UUID  02:自增
		 CodeGenerateFactory.codeGenerate(tableName, codeName,entityPackage,keyType);
	}
}
