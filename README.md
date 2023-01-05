# Kampanya-Api
<b>1.API TANITIM</b>
Kullanıcıların kampanya girebilecekleri ve kampanyalarını diledikleri zaman yayınlayıp, diledikleri zaman yayından kaldırabilecekleri ve kampanyaya ait birçok işlevi uygulayabilecekleri bir API dır.

Kampanya ilk verildiğinde TSS, ÖSS ve Diğer kategorisi için "Onay Bekliyor" durumunda, bunların dışındaki kategoriler için ise "Aktif" durumuna geçer. 

Aynı kategoride, aynı başlık ve açıklamaya sahip kampanya girildiğinde "Mükerrer" olarak işaretlenir ve mükerrer ilanların durumu güncellenemez.

"Onay Bekliyor" durumundaki kampanya onaylandığında "Aktif" hale gelir. 

Kullanıcı "Aktif" durumdaki veya "Onay Bekliyor" durumdaki ilanını "Deaktif" yapabilir. 

Kampanya Kısıtları

Kampanya İlan Başlığı : Harf (Türkçe karakterler dahil) veya Rakam ile başlamalıdır, en az 10, en fazla 50 karakter olabilir. 
Kampanya Detay Açıklaması : En az 20, en fazla 200 karakter olabilir, özel karakterler kullanılabilir 
Kampanya Kategorisi : Tamamlayıcı Sağlık Sigortası(TSS, Özel Sağlık Sigortası(ÖSS), Hayat Sigortası, Diğer olabilir (Yeni kategori eklenmeyecek gibi düşünülebilir)

<b>2.KULLANILAN TEKNOLOJİLER</b>
![teknolojiler](https://user-images.githubusercontent.com/82769279/210875256-78b01c99-e74c-405e-a831-2d9e815f0bf9.png)


<b>3.API KULLANIMI</b>
Metodlar:

1.info: Api ‘ın çalışıp çalışmadığını kontrol etmek için kullanılan metod.
![info](https://user-images.githubusercontent.com/82769279/210874580-a42fa1d9-887a-4750-8bad-1a60cc33a1e5.png)

2.createoffer: Yeni kampanya girmek için kullanılan metod.
![create](https://user-images.githubusercontent.com/82769279/210874621-a4eddf9d-3bb6-42e2-b894-6ad900f476ad.png)

3.readoffer: Girilen kampanyaları görüntülemek için kullanılan metod.
![read](https://user-images.githubusercontent.com/82769279/210874693-daa6a2c5-e389-40f0-8e8b-3e1717b79fd0.png)

4.approveoffer: Girilen kampanyaları onaylamak için kullanılan metod.
![approve](https://user-images.githubusercontent.com/82769279/210874766-ec787c12-cefc-4e42-9d3d-c3bb5930679c.png)

Bu metod ile mükerrer olan kampanya statüsü değiştirilemez.
Örneğin 4 numara id li kampanyada olduğu gibi.
![mükerrer](https://user-images.githubusercontent.com/82769279/210874857-78472791-1368-4719-b74c-b1b3eaf7e076.png)
![mükereraprove](https://user-images.githubusercontent.com/82769279/210874879-2baf7046-8aa2-464e-9dc7-9c99735caeab.png)

5.deactivateoffer: Girilen kampanyaları inaktif etmek için kullanılan metod.
![deactivate](https://user-images.githubusercontent.com/82769279/210874959-24929f07-adc3-4347-9dde-c10c1cee6c77.png)

Bu metod ile mükerrer olan kampanya statüsü değiştirilemez.
Örneğin 4 numara id li kampanyada olduğu gibi.
![mükerrer](https://user-images.githubusercontent.com/82769279/210874991-392ef0ae-c6ba-478e-a52f-fdc7b9bf1577.png)
![mükerrerdeac](https://user-images.githubusercontent.com/82769279/210874998-5d92eaab-0dca-40c8-a781-24cc2b387d21.png)

6./dashboard/classifieds/statistics: Kayıtlı tüm kampanyaların toplamda hangi durumlarda olduğunun istatistiksel olarak listelenmesi için kullanılan metod.
![stats](https://user-images.githubusercontent.com/82769279/210875051-5fe4e791-fe25-4476-96a5-d54b0de0b80e.png)











