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