-- 1.SPU表来表示产品（1个SPU对应多个SKU）
-- 2.SKU表来表示产品具体规格型号
-- 3.动态属性（key）（1个动态属性对应多个属性值）
-- 4.动态属性值（value）
--	 网络类型-电信/移动
--   颜色-白色/...

-- 动态属性KEY-value结果对应SKU关联，多对1的关系

create table spu(
	id 
	name
)

create table sku(
	id 
	name
)

create table attr_key(
	-- 版本
	-- 网络类型
	-- 机身颜色
)
-- attr_key 关联 attr_value
create table attr_value(
	-- iPhone 11 Pro 
	-- iPhone 11 Pro Max
	-- 银色
	-- 金色
	-- ...
)

create table product_item(
	sku
	attr_value
)