# 學生管理系統
<h3>自學程式有一段時間了，都沒有什麼作品所以決定寫一個學生管理系統，歡迎大家一起交流一起進步</h3>
<p>1.開發環境</p>
  <p>作業系統：windows10 專業版</p>
  <p>IDE：Mars Release (4.5.0)</p>
  <p>JDK：1.8.0.144</p>
  <p>使用框架：Spring3.1.0、mybatis3.4.5、jquery-3.2.1、Buttons.css</p>
  <p>資料庫：MySQL 5.7版</p>
<p>2.進度</p>
  <p>2017/11/17 將所需的jar檔與package建立完畢與測試框架基本功能是否正常運行</p>
  <p>2017/11/18 新增首頁並完成老師和學生的登入功能</p>
  <p>2017/11/19 新增學生頁面，和完成Menu清單</p>
  <p>2017/11/25 封裝RequestBean和ResponseBean讓接收與回傳統一寫在一起</p>
  <p>2017/11/26<br>
  		<ol>
  			<li>完成學生基本資料頁面</li>
  			<li>修正DateUtil西元民國日期轉換的bug</li>
  			<li>在AbstractController中加入取得UserID和UserName</li>
  			<li>登入頁面改成原本的寫法不使用共用Controller(因如果繼承AbstractController需要實現getUserID與getUserName)</li>
  			<li>練習使用formData實現ajax的檔案上傳</li>
  			<li>上網找如何取得Json的key值</li>
  			<li>使用link匯入css檔案時，瀏覽起開啟會有緩存，有更改時，需要清存緩存在開啟網頁，否則會瀏覽器會取得緩存的css</li>
  		</ol> 		
  </p>
  <p>2017/12/03<br>
  		<ol>
  			<li>新增教師登入後的頁面</li>
  			<li>修改底層Controller方法參數</li>
  			<li>新增共用的外部設定檔</li>
  			<li>加入班級資訊的table</li>
  			<li>新增formUtil.js 以後和表單相關的方法都會想入這</li>
  			<li>學到css可共用多個class</li>
  			<li>學到jQuery中find的用法</li>
  		</ol>
  </p>
  <p>2017/12/03<br>
  		<ol>
  			<li>修改log4j(改為xml格式的，使用DOMConfigurator.configure()讀取)</li>
  			<li>加入查詢班級資訊的功能(尚未寫入表格中，目前只做到從資料庫撈出資料傳回前端</li>
  			<li>新增BaseConstant的edtiData、GRID_RESULT參數</li>  			
  		</ol>
  </p>
  <p>2017/12/16 相隔快兩個禮拜終於更新了(不能在懶惰下去啦)
  		<ol>
  			<li>ApplicationContextUtil提供一般類別取得Spring外部設定檔所配置的bean</li>
  			<li>新增ContextFilter每次呼叫Controller時載入Spring設定檔</li>
  			<li>新增Dao框架
  				<ul>
  					<li>將原本的c3p0連接池改為jndi</li>
  					<li>新增SqlGenerate取得Mybaits的Sql語法和Sql參數</li>
  					<li>SchDaoAdvice執行manager前的AOP切入點(將Dao注入)</li>
  					<li>DaoFactory控管Dao(取得與創見Dao)</li>  					
  					<li>Query設定查詢的參數、Sql語法用</li>
  					<li>DBResultSetList、DBResultSet為查詢返回的類別(目前只完成DBResultSetList)</li>
  				</ul>
  			</li>
  		</ol>
  </p>
