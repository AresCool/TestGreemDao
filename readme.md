# *******************************
@Entity：告诉GreenDao该对象为实体，只有被@Entity注释的Bean类才能被dao类操作  <br />
@Id：对象的Id，使用Long类型作为EntityId，否则会报错。(autoincrement = true)表示主键会自增，如果false就会使用旧值  <br />
@Property：可以自定义字段名，注意外键不能使用该属性  <br />
@NotNull：属性不能为空  <br />
@Transient：使用该注释的属性不会被存入数据库的字段中  <br />
@Unique：该属性值必须在数据库中是唯一值  <br />
@Generated：编译后自动生成的构造函数、方法等的注释，提示构造函数、方法等不能被修改  <br />
# *******************************
增加单个数据   <br />
getShopDao().insert(shop);  <br />
getShopDao().insertOrReplace(shop);  <br />
增加多个数据   <br />
getShopDao().insertInTx(shopList);  <br />
getShopDao().insertOrReplaceInTx(shopList);  <br />
查询全部   <br />
List< Shop> list = getShopDao().loadAll();  <br />
List< Shop> list = getShopDao().queryBuilder().list();  <br />
查询附加单个条件   <br />
.where()  <br />
.whereOr()  <br />
查询附加多个条件   <br />
.where(, , ,)  <br />
.whereOr(, , ,)  <br />
查询附加排序   <br />
.orderDesc()  <br />
.orderAsc()  <br />
查询限制当页个数   <br />
.limit()
查询总个数   <br />
.count()  <br />
修改单个数据   <br />
getShopDao().update(shop);  <br />
修改多个数据   <br />
getShopDao().updateInTx(shopList);  <br />
删除单个数据   <br />
getTABUserDao().delete(user);  <br />
删除多个数据   <br />
getUserDao().deleteInTx(userList);  <br />
删除数据ByKey   <br />
getTABUserDao().deleteByKey();  <br />