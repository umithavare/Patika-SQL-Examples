# Patika-SQL-Examples
# Notes and assignments I took while learning sql.
* SQL declerative bir dildir.

* SQL, yapılandırılmış bir dildir ve belirli bir söz dizimine sahiptir. SQL kullanarak veritabanlarında sorgular yazabilir, veritabanı şemalarını oluşturabilir, veritabanı nesnelerini yönetebilir ve veritabanı işlemleri gerçekleştirebilirsiniz. SQL, farklı veritabanı yönetim sistemleri arasında genellikle taşınabilirlik sağlayan standart bir dil olarak kabul edilir, yani birçok veritabanı yönetim sistemi SQL'i destekler.

## WHERE KEYWORD

```SQL
SELECT * FROM football_player WHERE Country == 'France';
```


```SQL
SELECT * FORM film WHERE replacement_cost >= 12.99;
```

# WHERE AND LOGIC OPERATORS
* **AND** command'ini kullanarak sorgumuza ekleme yapip daha detayli yapabiliriz.


```SQL
SELECT first_name, last_name FROM actor
WHERE first_name = 'Penelope' AND last_name = 'Monroe';
```

# AND, OR, NOT
* **AND** two condition must be true;
* **OR** if one of the conditions is true then the statement become true ;
* **NOT** it lists the excat opposite of the written statement;

```SQL
SELECT * FROM film WHERE NOT (rental_rate >= 5.00 OR rental_rate = 2.99);
```

# BETWEEN ve IN
## BETWEEN
Aşağıdaki sorgumuzda AND mantıksal operatörü yardımıyla film tablosunda bulunan verilerimizi uzunluğu 140 tan küçük eşit VE 100 den büyük eşit olmak üzere sıralıyoruz.
```SQL
SELECT * FROM film
WHERE length >= 100 AND length <= 140;
```
Burada temel olarak yaptığımız belirli aralıkta bulunan verileri sıralamak. Bunun BETWEEN ... AND yapısını kullanarak da yapabiliriz.

## BETWEEN AND Söz Dizimi
```SQL
SELECT <sütun_adı>, <sütun_adı>, ... FROM <tablo_adı>
WHERE <koşul>;
```
## BETWEEN Örnek Kullanım
```SQL
SELECT * FROM film
WHERE length BETWEEN 100 AND 140; -- WHERE length >= 100 AND length <= 140 ifadesi ile aynı sonucu verir.
```
Burada dikkat edilmesi gereken nokta 100 ve 140 sınır değerleri aralığa dahildir.

## IN
Şöyle bir senaryo düşünelim, yine film tablosundan uzunluğu 30, 60, 90 veya 120 dakikaya eşit olan verileri sıralayalım.
```SQL
SELECT * FROM film
WHERE length = 30 OR length = 60 OR length = 90 OR length = 120;
```
sorgusuyla verileri aldık ancak burada şöyle bir sorunumuz var peki 4 farklı değer için değil 14 farklı değer için bu sorgumuzu gerçekleştirmek için 14 ayrı OR mantıksal operatörü kullanmamız gerekirdi. Bunun yerine istenilen değerleri liste haline geitip IN anahtar kelimesiyle kullanabiliriz.

## IN Söz Dizimi
```SQL
SELECT <sütun_adı>, <sütun_adı>, ... FROM <tablo_adı>
WHERE <sütun_adı> IN (değer1, değer2, ...);
```
## IN Örnek Kullanım
```SQL
SELECT * FROM film
WHERE length IN (30,60,90,120);
```
# LIKE ve ILIKE
Aşağıdaki sorgumuzda actor tablomuzda bulunan tüm sütunlardaki verileri first_name sütununda ki değeri 'Penelope' olmak üzere getiriyoruz.
```SQL
SELECT *
FROM actor
WHERE first_name = 'Penelope';
```
Ancak bizler bazı durumlarda bu şekilde tam eşleşme değil belirli şablonlara uyan koşulların sağlanmasını isteriz. Örneğin aşağıdaki sorgumuzda first_name sütunun 'Penelope' değerine eşit olmasını değil, ilk harfin 'P' olması koşulunu sağlar. Bunun için LIKE operatörünü kullanırız.

```SQL
SELECT *
FROM actor
WHERE first_name LIKE 'P%';
```
Burada kullanılan % karakteri sıfır, bir veya daha fazla karakteri temsil eder ve Wildcard olarak isimlendirilir. Bir diğer wildcard karakteri _ karakteridir ve bir karakteri temsil eder.

## LIKE Söz Dizimi
```SQL
SELECT <sütun_adı>, <sütun_adı>, ...
FROM <tablo_adı>
WHERE <sütun_adı> LIKE <şablon>;
```
ILIKE operatörü LIKE operatörünün case - insensitive versiyonudur.

# DISTINCT ve COUNT
## DISTINCT
Şimdiye kadar yaptığımız SQL sorgularında genellikle verileri belirli koşullar altında sıraladık. Dikkat ettiyseniz bir çok durumda aynı sütün içerisinde birbirinin aynı olan veriler ile karşılaştık. Örneğin dvdrental veritabanı içerisinde bulunan film tablosundaki replacement_cost, rental_rate gibi sütunlar birbirini tekrar eden verilerden oluşmaktadır. Bazı durumlarda bir sütun içerisinde bulunan farklı değerleri görmek isteriz.

```SQL
SELECT DISTINCT rental_rate
FROM film;
```
sorgusu bize rental_rate sütununda bulunan birinden farklı 2.99, 0.99, 4.99 verilerini gösterir.

### SELECT DISTINCT Söz Dizimi
```SQL
SELECT DISTINCT <sütun_adı>, <sütun_adı>, ...
FROM <tablo_adı>;
```
## COUNT
COUNT aggregate fonksiyonu ilgili sorgu sonucunda oluşan veri sayısını bildirir. Aşağıdaki sorguda ismi 'Penelope' olan aktörleri sıralıyoruz.
```SQL
SELECT *
FROM actor
WHERE first_name = 'Penelope';
```
ancak veri sayısını bulmak istersek COUNT fonksiyonunu kullanırız.

```SQL
SELECT COUNT(*)
FROM actor
WHERE first_name = 'Penelope';
``` 
Yukarıda da belirttiğimiz gibi COUNT fonksiyonu ile sorgu sonucunda ortaya verileri sayıyoruz. Bu nedenle COUNT(*) veya COUNT(sütun_adı) aynı sonucu verir.


# PSQL ve Uygulama I
## PSQL
PSQL, PostgreSQL ile birlikte gelen terminal tabanlı bir kullanıcı arayüzüdür. PSQL sayesinde komut satırında sorgular yazıp, sonuçlarını görebiliriz. Aşağıda temel PSQL komutlarının ilk bölümünü bulabilirsiniz.

1- SQL ile PostgreSQL'e bağlanmak.
```SQL
psql -U <kullanıcı_adı>
```
2- Kullanıcıya ait şifreyi girdikten sonra varsayılan veritabanı postgres'e bağlanıyor.
```SQL
postgres=#
```
3- Bulunan veritabanlarını listelemek için:
```SQL
\l veya \list
``` 
4- Bizim örneğimizde dvdrental veritabanına bağlanacağız.
```SQL
\c dvdrental veya \connect dvdrental
```
5- Bağlanılan dvdrental veritabanında bulunan tabloları listelemek için:
```SQL
\dt
```
6- Herhangi bir tablonun sütunlarını ve tablo detaylarını görmek için:
```SQL
\d <tablo_adı>
```
### Örnek Sorgu Senaryoları
1- customer tablosunda bulunan first_name değeri ve last_name değeri 'A' karakteri ile başlayan verileri sıralayınız.
```SQL
SELECT * FROM customer
WHERE first_name LIKE 'A%' AND last_name LIKE 'A%';
```
2- film tablosunda bulunan ve uzunluğu 80 ile 120 arasında bulunan ve aynı zamanda rental_rate değeri 0.99 veya 2.99 olan verileri sıralayınız.
```SQL
SELECT * FROM film
WHERE (length BETWEEN 80 AND 120) AND (rental_rate IN (0.99, 2.99));
```
#### PSQL terminal ekranından çıkmak için:
```SQL
\q
```

# ORDER BY
ORDER BY anahtar kelimesi sayesinde bizler verilerimizi herhangi bir sütunda bulunan değerlere göre azalan veya artan bir şekilde sıralayabiliriz.

## ORDER BY Söz Dizimi
```SQL
SELECT <sütun_adı>, <sütun_adı>, ...
FROM <tablo_adı>
ORDER BY <sütun_adı>, <sütun_adı>, ... ASC|DESC;
```
### ORDER BY Örnek Kullanım
```SQL
SELECT *
FROM film
ORDER BY title (ASC);
```
Bu sorgumuzda dvdrental veritabanında bulunan film tablosundaki tüm sütunları title sütununda bulunan verilere göre artan (ASC) şeklinde sıralıyoruz.

ASC sıralama varsayılan olduğu için ayrı bir şekilde yazılması zorunluluğu yoktur ancak sorguyu belirginleştirmesi açısından genelde yazılır.
```SQL
SELECT *
FROM film
ORDER BY title ASC length DESC;
```
Sıralama birden fazla sütuna göre de yapılabilir. Yukarıdaki örneğimizde sıralama title sütununa göre artan length sütununa göre azalan şeklinde yapılıyor.
```SQL
SELECT *
FROM film
WHERE title LIKE 'A%'
ORDER BY title ASC length DESC;
```
Yukarıdaki örneğimizde de gördüğümüz gibi sıralama işlemi, koşuldan sonra yazılır.



# LIMIT ve OFFSET
## LIMIT
Şimdiye kadar yaptığımız SQL sorgularında genellikle verilerin tamamını belirli koşullar altında sıraladık. Bazı durumlarda ise koşullarımızı sağlayan verilerin tamamını değil belirli sayıda olanlarını sıralamak isteriz, bunun için LIMIT anahtar kelimesini kullanırız.

Şöyle bir senaryo üzerine düşünelim. dvdrental veritabanında bulunan film tablosundan B ile başlayan filmleri uzunluklarına göre en uzun olan 10 filmi sıralayalım.
```SQL
SELECT *
FROM film
WHERE title LIKE 'B%'
ORDER BY length DESC
LIMIT 10;
```
Yukarıdaki sorgumuzda da görmüş olduğunuz gibi önce koşullamayı, sonra gruplamayı en son ise LIMIT kullanarak istediğimiz veri sayısını belirttik.

## OFFSET
Bazı durumlarda sonuç olarak gördüğümüz veri grubu içerisinden bazılarını "pass" geçmek isteriz. Yukarıdaki senaryomuzu tekrar düşünelim, dvdrental veritabanında bulunan film tablosundan B ile başlayan filmleri uzunluklarına göre sıralayalım ancak en uzun 6 filmi "pass" geçelim ve sonrasındaki 4 filmi sıralayalım. Bu durumda LIMIT 4 ve OFFSET 6 olacak.
```SQL
SELECT *
FROM film
WHERE title LIKE 'B%'
ORDER BY length DESC
OFFSET 6
LIMIT 4;
```



# Aggregate Fonksiyonlar - MIN, MAX, SUM, AVG
Aggregate fonksiyonları yardımıyla bizler veri kümelerimizden sonuçlar çıkarabiliriz. Ne demek istiyorum? Şu senaryoları düşünelim.

* Toplam kaç adet müşterimiz var?
* Elimizde bulunan filmlerin ortalama uzunluğu nedir?

Bu şekilde belirli veri kümelerinden tek bir sonuç çıkarmak için aggregate fonksiyonları kullanırız.

## Örnek Kullanımlar
AVG fonksiyonunu kullandığımız sayısal değerlerden oluşan sütunun ortalama değerini alırız.
```SQL
SELECT AVG(length)
FROM film;
```
sorgusu sayesinde film tablosunda bulunan length sütunundaki değerlerin ortalamasını alırız. SUM fonksiyonunu kullandığımız sayısal değerlerden oluşan sütunun toplam değerini alırız.
```SQL
SELECT SUM(length)
FROM film;
```
sorgusu sayesinde film tablosunda bulunan length sütunundaki değerlerin toplamını alırız. MAX fonksiyonunu kullandığımız sayısal değerlerden oluşan sütunun en yüksek değerini alırız.
```SQL
SELECT MAX(length)
FROM film;
```
sorgusu sayesinde film tablosunda bulunan length sütunundaki değerlerin en yüksek değerini alırız. MIN fonksiyonunu kullandığımız sayısal değerlerden oluşan sütunun en düşük değerini alırız.
```SQL
SELECT MIN(length)
FROM film;
```
sorgusu sayesinde film tablosunda bulunan length sütunundaki değerlerin en düşük değerini alırız.
<br>
<br>

# GROUP BY
Bizler şimdiye kadar olan sorgularımızın tamamında sorguları yaparken genel veri kümesinin tamamı üzerine düşündük, ancak bazı durumlarda aynı sonuçları veri kümesinin içerisinde bulunan farklı gruplarda da bulmak isteyebiliriz. Senaryomuzu şu şekilde düşünelim, dvdrental veritabanında rental_rate sütununda bizim 3 farklı değerimiz var (0.99, 2.99, 4.99). Biz bu 3 farklı değer için en uzun filmi bulmaya çalışalım.
```SQL
SELECT MAX(length) FROM film
WHERE rental_rate = 0.99;
SELECT MAX(length)
FROM film
WHERE rental_rate = 2.99;
SELECT MAX(length)
FROM film
WHERE rental_rate = 4.99;
```
İstediğimiz sonuçları elde ediyoruz ancak şöyle bir sorunumuz var 3 farklı değer yerine 30 farklı değer olsaydı? İşte bu şekilde senaryolar için yani verileri gruplama için GROUP BY anahtar kelimesi kullanılır.

## GROUP BY Söz Dizimi
```SQL
SELECT <sütun_adı>, <sütun_adı>, ... (veya aggregate func) FROM <tablo_adı>
GROUP BY <sütun_adı>, <sütun_adı>, ...
```
Burada şuna dikkat etmemiz gerekir, SELECT anahtar kelimesinde bulunan sütunların GROUP BY anahtar kelimesi içerisinde bulunması gerekir.

### GROUP BY Örnek Kullanım
Yukarıdaki senaryomuzu GROUP BY anahtar kelimesini kullanarak gerçekleştirelim. Dikkat ettiğiniz üzere SELECT ile kullanılan rental_rate sütunu GROUP BY satırında da kullanılmıştır.
```SQL
SELECT rental_rate, MAX(length) FROM film
GROUP BY rental_rate;
```

# HAVING
HAVING anahtar kelimesi sayesinde gruplandırılmış verilere koşullar ekleyebiliriz. Hemen aklımıza WHERE anahtar kelimesi geldi değil mi? Ancak WHERE anahtar kelimesi ile biz satır bazlı koşullar verebiliyoruz.

Şöyle bir senaryomuz olsun. Her bir rental_rate oranına karşılık gelen film sayısını bulalım. Bunu GROUP BY ile gerçekleştirebiliriz. Ancak bu kez 1 adım öteye gidip şöyle bir koşul ekleyelim toplam film sayısı 325 ten fazla olan rental_rate oranlarını görelim. Bu durumda GROUP BY ile elde ettiğimiz toplam film sayılarına koşul eklememiz gerekir.
```SQL
SELECT rental_rate, COUNT(*) FROM film GROUP BY rental_rate HAVING COUNT(*) > 325;
```

# ALIAS (AS)
AS anahtar kelimesi sayesinde sorgular sonucu oluşturduğumuz sanal tablo ve sütunlara geçici isimler verebiliriz.

## ALIAS SÜTUN KULLANIMI
```SQL
SELECT <sütun_adı> AS <geçici_ad>
FROM <tablo_adı>;
```
## ALIAS TABLO KULLANIMI
```SQL
SELECT <sütun_adı>, <sütun_adı>...
FROM <tablo_adı> AS <geçici_ad>;
```

# Tablo Oluşturmak ve Silmek (CREATE - DROP)
## Tablo Oluşturmak - CREATE
SQL ile yeni bir tablo oluşturmak için CREATE anahtar kelimesi kullanılır. Tablo oluştururken sonrasında daha detaylı konuşacağımız 3 önemli başlık daha vardır.

Sütunlara verilecek isim, sütunların veri tipi ve varsa sütunlarda bulunan kısıtlama yapıları.

### Tablo Oluşturmak - CREATE Söz Dizimi
```SQL
CREATE TABLE <tablo_adı> (
<sütun_adı> <veri_tip> (kısıtlama_adı>,
<sütun_adı> <veri_tip> (kısıtlama_adı>,
....
);
```
### Tablo Oluşturmak - CREATE Örnek Kullanım
author isminde bir tablo oluşturalım, id, first_name, last_name, email, birthday sütunları olsun. Veri tipleri ve kısıtlama yapılarıyla ilgili sonrasında detaylı olarak konuşacağız.
```SQL
CREATE TABLE author (
id SERIAL PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
email VARCHAR(100)
birthday DATE
);
```

## Tablo Silmek - DROP
Oluşturduğumuz tabloları silmek için DROP anahtar kelimesi kullanılır.

### Tablo Silmek - DROP Söz Dizimi
```SQL
DROP TABLE (IF EXISTS) <tablo_adı>;
```
Burada IF EXISTS yapısını kullanarak yanlış tablo ismi yazımı durumunda hata mesajı almayı önleriz.

### Tablo Silmek - DROP Örnek Kullanım
"test" isimli tablomuzu silmek istersek;
```SQL
DROP TABLE IF EXISTS test;
```

# Tablo Verilerini Güncellemek (UPDATE - DELETE)
Bir tabloda bulunan verileri güncellemek veya silmek için öncelikle örnek bir tablo oluşturup içine 5 date veri yerleştireceğim.

Bunun için Mockaroo benzeri servisleri kullanabiliriz. Aşağıdaki örnek tablo oluşturma ve veri girme komutlarını bulabilirsiniz.
```SQL
CREATE TABLE my_apps (
id INT,
name VARCHAR(50),
price VARCHAR(50)
);
INSERT INTO my_apps (id, name, price) values (1, 'Ronstring', '$0.96');
INSERT INTO my_apps (id, name, price) values (2, 'Duobam', '$3.44');
INSERT INTO my_apps (id, name, price) values (3, 'Tresom', '$2.21');
INSERT INTO my_apps (id, name, price) values (4, 'Redhold', '$2.52');
INSERT INTO my_apps (id, name, price) values (5, 'Y-find', '$9.14');
``` 
## UPDATE
UPDATE anahtar kelimesi sayesinde tablomuzda bulunan verileri güncelleyebiliriz.
```SQL
UPDATE Söz Dizimi
UPDATE <tablo_adı>
SET <sütun_adı> = değer,
<sütun_adı> = değer,
----
WHERE <koşul_adı>;
```
### UPDATE Örnek Kullanım
my_apps tablosunda bulunan ve id 2' ye eşit olan verimizin name sütunundaki degerini 'Mayak' price sütunundaki değerini '$5.22' ile değiştirelim.
```SQL
UPDATE my_apps
SET name = 'Mayak',
price = '$5.22'
WHERE id = 2;
```
## DELETE
DELETE anahtar kelimesi sayesinde tablomuzda bulunan verileri silebiliriz.

### DELETE Söz Dizimi
```SQL
DELETE FROM <tablo_adı>
WHERE <koşul_adı>;
```
### DELETE Örnek Kullanım
my_apps tablosunda bulunan name sütunundaki verisi 'Tresom' olan satırı silelim.
```SQL
DELETE FROM my_apps
WHERE name = 'Tresom';
```

Birincil Anahtar ve Yabancı Anahtar (PRIMARY KEY ve FOREIGN KEY)
======

## PRIMARY KEY

**PRIMARY KEY** bir tabloda bulunan veri sıralarını birbirinden ayırmamızı sağlayan bir kısıtlama (constraint) yapısıdır. O tabloda bulunan
veri sıralarına ait bir "benzersiz tanımlayıcıdır".
- Benzersiz (Unique) olmalıdır.
- NULL değerine sahip olamaz.
- Bir tabloda en fazla 1 tane bulunur.

![PRIMARY KEY](https://github.com/Kodluyoruz/taskforce/blob/main/sql101/PrimaryKeyAndForeignKey/figures/PrimaryKey.gif)

Yukarıda bulunan görselimizde de gördüğünüz gibi STUDENT tablosunda bulunan **StudentId** sütunu PRIMARY KEY yapısındadır ve her satırı (veri kaydını) diğer
satırlardan ayırmamızı sağlar.

## FOREIGN KEY

**FOREIGN KEY** bir tabloda bulunan herhangi bir sütundaki verilerin genelde başka bir tablo sütununa referans vermesi durumudur, tablolar arası ilişki kurulmasını sağlar.
- Bir tabloda birden fazla sütun FK olarak tanımlanabilir.
- Aynı sütunun içerisinde aynı değerler bulunabilir.


![PRIMARY KEY](https://github.com/Kodluyoruz/taskforce/blob/main/sql101/PrimaryKeyAndForeignKey/figures/ForeignKey.gif)

Yukarıda bulunan görselimizde de gördüğünüz gibi STUDENT tablosunda bulunan **courseId** sütunu FOREIGN KEY yapısındadır ve başka bir tablo olan "Course" tablosundaki
**courseId** sütununa referans verir.


Veri Tipleri I
======

## Temel Veri Tipleri
- Sayısal Veri Tipleri
- Karakter Veri Tipleri
- Boolean Veri Tipleri
- Date / Time Veri Tipleri

###  Sayısal Veri Tipleri

| İsim        | Range          | 
| ------------- |:-------------|
| smallint      | 	-32768 to +32767 |
| integer      | -2147483648 to +2147483647      |
| bigint | -9223372036854775808 to +9223372036854775807      |
| decimal     | up to 131072 digits before the decimal point; up to 16383 digits after the decimal point      |
| numeric      | up to 131072 digits before the decimal point; up to 16383 digits after the decimal point      | 
| real      | 6 decimal digits precision      |
| double precision      | 15 decimal digits precision      |
| smallserial      | 1 to 32767     |
| serial      | 1 to 2147483647     |
| bigserial     | 1 to 9223372036854775807     |


Veri Tipleri II
======

##  Karakter Veri Tipleri

| İsim        | Tanım         | 
| ------------- |:-------------|
| character varying(n), varchar(n)      | 	variable-length with limit |
| character(n), char(n)      | fixed-length, blank padded     |
| text | variable unlimited length      |

Sınırlı sayıda karekter kullanımı için VARCHAR veya CHAR veri tipleri kullanılır. VARCHAR veri tipi doldurulmayan karakterleri yok sayar, CHAR veri tipi ise doldurulmayan
karakterler için boşluk bırakır. Sınırsız karekter kullanımı için ise TEXT veri tipi kullanılır.

##  Boolean Veri Tipleri

TRUE, FALSE veya NULL (Bilinmeyen) değerlerini alabilirler.

- TRUE: true, yes, on, 1
- FALSE: false, no, off, 0

##  Zaman / Tarih Veri Tipleri

| İsim        | Tanım         | 
| ------------- |:-------------|
| timestamp [ (p) ] [ without time zone ]     | 	both date and time (no time zone) |
| timestamp [ (p) ] with time zone      | both date and time, with time zone     |
| date | date (no time of day)      |
| time [ (p) ] [ without time zone ] | time of day (no date)      |
| time [ (p) ] with time zone | time of day (no date), with time zone      |
| interval [ fields ] [ (p) ] | time interval     |




ALTER ve NOT NULL
======

## NOT NULL

Birçok durumda bizler herhangi bir sütuna yazılacak olan verilere belirli kısıtlamalar getirmek isteriz. Örneğin yaş sütünunda sadece sayısal verilerin
olmasını isteriz ya da kullanıcı adı sütununda bilinmeyen (NULL) değerlerin olasını istemeyiz. Bu gibi durumlarda ilgili sütunda **CONSTRAINT** kısıtlama
yapıları kullanılır.

**NULL** bilinmeyen veri anlamındadır. Boş string veya 0 verilerinden farklıdır. Şu şekilde bir senaryo düşünelim bir kullanıcının email hesabı yoksa buradaki veriyi
boş string şeklinde düşünebiliriz. Acak eğer kullanıcının maili var ancak ne olduğunu bilmiyorsak bu durumda o veri NULL (bilinmeyen) olarak tanımlanabilir.

### NOT NULL Kullanımı

Employees şeklinde bir tablomuzu oluşturalım. Tablodaki first_name ve last_name sütunlarında bilinmeyen veri istemiyoruz, bu sütunlarda NOT NULL kısıtlama yapısı
kullanabiliriz.

```SQL
CREATE TABLE Employees (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    age INTEGER
);
```

### ALTER ve NOT NULL

ALTER anahtar kelimesini varolan bir tabloda değişiklik yapmak için kullanılır. Aşağıdaki senaryoda bir sütuna **NOT NULL** kısıtlaması vermek için aşağıdaki
söz dizimi yapısı kullanılır.

```SQL
ALTER TABLE <tablo_adı>
ALTER COLUMN <sütun_adı>
SET NOT NULL;
```



UNIQUE
======
**UNIQUE** kısıtlaması ile uyguladığımız sütundaki verilerin birbirlerinden farklı benzersiz olmalarını isteriz. PRIMARY KEY kısıtlaması kendiliğinden **UNIQUE**
kısıtlamasına sahiptir.

NOT NULL kısıtlamasında olduğu gibi tablo oluştururken veya ALTER komutu ile beraber tablo oluştuktan sonra da kullanabiliriz.

### UNIQUE Kullanımı

Employees şeklinde bir tablomuzu oluşturalım. Tablodaki email sütununda bulunan verileri **UNIQUE** olarak belirlemek istersek.

```SQL
CREATE TABLE Employees (
    ---
    emaile VARCHAR(100) UNIQUE,
    ----
);
```

### ALTER ve UNIQUE

```SQL
ALTER TABLE <tablo_adı>
ADD UNIQUE <sütun_adı>
```

Bu arada herhangi bir sütuna **UNIQUE** kısıtlaması getirirsek ve öncesinde UNIQUE olmayan verileri kaldrmamız gerekir.

CHECK
======
**CHECK** kısıtlaması ile uyguladığımız sütundaki verilere belirli koşullar verebiliriz. Örneğin age (yaş) olarak belirlediğimiz bir sütuna negatif değerler verebiliriz
veya web portaline üye olan kullanıcıların yaşlarının 18 yaşından büyük olması gibi kendi senaryolarımıza uygun başka kıstlamalar da vermek isteyebiliriz.

CHECK kısıtlamasını da tablo oluştururken veya ALTER komutu ile beraber tablo oluştuktan sonra kullanabiliriz.

### CHECK Kullanımı

Employees şeklinde bir tablomuzu oluşturalım. Tablodaki age sütununda bulunan verilerin 18'e eşit veya büyük olmasını istiyoruz.

```SQL
CREATE TABLE Employees (
    ---
    age INTEGER CHECK (age>=18)
    ----
);
```

### ALTER ve CHECK

```SQL
ALTER TABLE <tablo_adı>
ADD CHECK (age>=18)
```

PSQL ve Uygulama II
======

## PSQL

PSQL, PostgreSQL ile birlikte gelen terminal tabanlı bir kullanıcı arayüzüdür. PSQL sayesinde komut satırında sorgular yazıp, sonuçlarını görebiliriz. Aşağıda temel
`PSQL` komutlarının ilk bölümünü bulabilirsiniz.

1. PSQL ile PostgreSQL'e host, port, kullanıcı adı ve veritabanı ismi ile bağlanmak için:
```
psql -h <host_name> -p <port_name> -U <kullanıcı_adı> <veritabanı_adı>
```
2. Yeni veritabanı oluşturmak için
```
CREATE DATABASE <veritabanı_adı>
```
3. Yeni tablo oluşturmak için
```
CREATE TABLE <tablo_adı> (
  <sütun_adı> VERİ TİPİ (KISITLAMA)
  ----
```
4. Tablo detaylarını görmek için
```
\d+ <tablo_adı>
```
5. Bir tablodaki sütun ismini değiştirmek için
```
ALTER TABLE <tablo_adı> RENAME COLUMN <sütun_adı> TO <yeni_sütun_adı>
```
6. Bir sütuna UNIQUE kısıtlaması eklemek için
```
ALTER TABLE <tablo_adı> ADD CONSTRAINT <kısıtlama_adı> UNIQUE <sütun_adı>
```


JOIN Kavramı (Birleştirme)
======
Veraitabanları çoğunlukla birbiri ile ilşkili olan tablolardan oluşur. Bu birbiri ile ilişkili olan tablardaki verileri farklı JOIN yapıları kullanarak sanal olarak birleştirip
daha anlamlı veriler haline getirebiliriz.


## INNER JOIN

INNER JOIN yapısı sayesinde birbiriyle ilişkili olan tabloların birbiriyle eşleşen  (kesişen) verilerini sıralayabiliriz. Senaryomuzda kitapları gösterdiğimiz **book**
tablosu ve yazarları gösterdiğimiz **author** tablosu var, author tablosunun id sütunuyla book tablosunun author_id sütunlarında bulunan veriler sayesinde her iki tabloya ait
bilgilerden daha anlamlı sonuçları elde edebiliriz.

Aşağıdaki SQL sorgusunda kitap isimlerini yazar isim ve soyisimler ile birlikte gösterebiliriz.

```SQL
SELECT book.title, author.first_name, author.last_name
FROM book
JOIN author ON author.id = book.author_id;
```

Yukarıdaki sorgumuzda tablolar arasındaki eşleşmeyi author.id ve book.author_id sütunları yardımıyla yapıyoruz.

![Inner Join](https://github.com/Kodluyoruz/taskforce/blob/main/sql101/InnerJoin/figures/InnerJoin.png)

Yukarıdaki görselimizde de gördüğümüz üzere INNER JOIN tablolar arasındaki eşleşen (kesişen) verileri sıralar. Bundan dolayı INNER JOIN yapısı simetriktir, author - book
tablolarının yerlerinin değiştirilmesi sonucu etkilemez.

### INNER JOIN Söz Dizimi
```SQL
SELECT <sütun_adı>, <sütun_adı> ...
FROM <tablo1_adı>
INNER JOIN <tablo2_adı>
ON <tablo1_adı>.<sütun_adı> = <tablo2_adı>.<sütun_adı>;
```
Buradaki tablo1 "left table", tablo2 "right table" olarak da adlandırılır.


LEFT JOIN
======

LEFT JOIN yapısındaki tablo birleştirmesinde, birleştirme işlemi tablo 1 (soldaki tablo) üzerinden gerçekleştirilir. Senaryomuzu şu şekilde düşünelim eğer tablo 1
olarak **book** tablosunu aldığımızda öncelikle book tablosundaki ilgili sütundaki tüm verileri alacağız, sonrasında bu verilerin eşleştiği ilgili tablo 2
sütunundaki verileri alacağız. Tablo 1 de olup Tablo 2 de olmayan veriler için **NULL** değeri kullanılır.


Aşağıdaki SQL sorgusunda kitap isimlerinin tamamını alıyoruz, sonrasında bu kitap isimleriyle eşleşebilen yazar isimlerini alıyoruz. Kitap isimlerine karşılık
olmayan yazarlar için NULL değeri alıyoruz.

```SQL
SELECT book.title, author.first_name, author.last_name
FROM book
LEFT JOIN author
ON author.id = book.author_id;
```

Yukarıdaki sorgumuz sonucunda göreceğimiz gibi kitapların yazar bilgisine sahip değilse NULL değerlerini alırız.

![Left Join](https://github.com/Kodluyoruz/taskforce/blob/main/sql101/LeftJoin/figures/LeftJoin.png)

Yukarıdaki görselimizde de gördüğümüz üzere LEFT JOIN tablolar arasındaki eşleşmeyi  tablo 1 (soldaki tablo) üzerinden belirlenir.

### LEFT JOIN Söz Dizimi
```SQL
SELECT <sütun_adı>, <sütun_adı> ...
FROM <tablo1_adı>
LEFT JOIN <tablo2_adı>
ON <tablo1_adı>.<sütun_adı> = <tablo2_adı>.<sütun_adı>;
```
Buradaki tablo1 "left table", tablo2 "right table" olarak da adlandırılır.

RIGHT JOIN
======

RIGHT JOIN yapısındaki tablo birleştirmesinde, birleştirme işlemi tablo 2 (sağdaki tablo) üzerinden gerçekleştirilir. Senaryomuzu şu şekilde düşünelim eğer tablo 2
olarak **author** tablosunu aldığımızda öncelikle author tablosundaki ilgili sütundaki tüm verileri alacağız, sonrasında bu verilerin eşleştiği ilgili tablo 1
sütunundaki verileri alacağız. Tablo 2 de olup Tablo 1 de olmayan veriler için **NULL** değeri kullanılır.


Aşağıdaki SQL sorgusunda yazar isim ve soyisim bilgilerinin tamamını alıyoruz, sonrasında eşleşebilen kitap isimlerini alıyoruz. Yazar bilgilerine karşılık
olmayan kitap isimleri için NULL değeri alıyoruz.

```SQL
SELECT book.title, author.first_name, author.last_name
FROM book
RIGHT JOIN author
ON author.id = book.author_id;
```

Yukarıdaki sorgumuz sonucunda göreceğimiz gibi yazarlara ait olmayan kitaplar NULL değerlerini alırız.

![Right Join](https://github.com/Kodluyoruz/taskforce/blob/main/sql101/RightJoin/figures/RightJoin.png)

Yukarıdaki görselimizde de gördüğümüz üzere LEFT JOIN tablolar arasındaki eşleşmeyi  tablo 1 (soldaki tablo) üzerinden belirlenir.

### RIGHT JOIN Söz Dizimi
```SQL
SELECT <sütun_adı>, <sütun_adı> ...
FROM <tablo1_adı>
RIGHT JOIN <tablo2_adı>
ON <tablo1_adı>.<sütun_adı> = <tablo2_adı>.<sütun_adı>;
```
Buradaki tablo1 "left table", tablo2 "right table" olarak da adlandırılır.

FULL JOIN
======

Full JOIN yapısındaki tablo birleştirmesinde, birleştirme işlemi her iki tablo üzerinden gerçekleştirilir. Senaryomuzu şu şekilde düşünelim eğer tablo 1
olarak **book** tablosunu aldığımızda öncelikle book tablosundaki ilgili sütundaki tüm verileri alacağız, sonrasında tablo 2 deki ilgili sütunlardan
tüm verileri alacağız. Tablo 1 de olup Tablo 2 de olmayan ve Tablo 2 de olup Tablo 1 de olmayan veriler için **NULL** değeri kullanılır.


Aşağıdaki SQL sorgusunda kitap isimlerinin tamamını alıyoruz, sonrasında yazar isimlerini alıyoruz. Eşleşemeyen veriler için NULL değeri alıyoruz.

```SQL
SELECT book.title, author.first_name, author.last_name
FROM book
FULL JOIN author
ON author.id = book.author_id;
```

Yukarıdaki sorgumuz sonucunda göreceğimiz gibi kitapların yazar bilgisine sahip değilse NULL değerlerini alırız, yazarlar kitap bilgisine sahip değilse
orada da NULL değerlerini alırız.

![Full Join](https://github.com/Kodluyoruz/taskforce/blob/main/sql101/FullJoin/figures/FullJoin.gif)

Yukarıdaki görselimizde de gördüğümüz üzere FULL JOIN tablolar arasındaki birleştirmeyi her iki tablo üzerinden belirlenir.

### FULL JOIN Söz Dizimi
```SQL
SELECT <sütun_adı>, <sütun_adı> ...
FROM <tablo1_adı>
FULL JOIN <tablo2_adı>
ON <tablo1_adı>.<sütun_adı> = <tablo2_adı>.<sütun_adı>;
```
Buradaki tablo1 "left table", tablo2 "right table" olarak da adlandırılır.



UNION
======
**UNION** operatörü sayesinde farklı SELECT sorgularıyla oluşan sonuçları tek bir sonuç kümesi haline getiririz.


### UNION Kullanımı

**bookstore** veritabanında iki adet sorgu yapıyoruz. İlk sorgumuzda sayfa sayısı en fazla olan 5 kitabı, ikinci sorgumuzda ise isme göre 5 kitabı sıralıyoruz. UNION
anahtar kelimesi sayesinde bu iki sorguyu da birleştirebiliriz.


```SQL
(
SELECT * 
FROM book
ORDER BY title
LIMIT 5
)
UNION
(
SELECT * 
FROM book
ORDER BY page_number DESC
LIMIT 5
);
```
UNION operatörü kullanılacağı sorguların, sütun sayıları eşit olmalıdır ve sütunlardaki veri tipleri eşleşmelidir.


### UNION Söz Dizimi

```SQL
SELECT <sütun_adı>, <sütun_adı>...
FROM <table1>
UNION
SELECT <sütun_adı>, <sütun_adı>...
FROM <table2>
```
### UNION ALL

UNION operatörü bize birleşik veriler içerisindeki tekrar edenleri göstermez. Tekrar edenleri görmek için **UNION ALL** kullanırız.


INTERSECT ve EXCEPT
======
**INTERSECT** operatörü sayesinde farklı SELECT sorgularıyla oluşan sonuçların kesişen verilerini tek bir sonuç kümesi haline getiririz.


### INTERSECT Kullanımı

**bookstore** veritabanında iki adet sorgu yapıyoruz. İlk sorgumuzda sayfa sayısı en fazla olan 5 kitabı, ikinci sorgumuzda ise isme göre 5 kitabı sıralıyoruz. INTERSECT
anahtar kelimesi sayesinde bu iki sorgu sonucunda oluşan veri kümelerinden kesişen verileri tek bir sonuçta birleştiririz.


```SQL
(
SELECT * 
FROM book
ORDER BY title
LIMIT 5
)
INTERSECT
(
SELECT * 
FROM book
ORDER BY page_number DESC
LIMIT 5
);
```
INTERSECT operatörü kullanılacağı sorguların, sütun sayıları eşit olmalıdır ve sütunlardaki veri tipleri eşleşmelidir.


### INTERSECT Söz Dizimi

```SQL
SELECT <sütun_adı>, <sütun_adı>...
FROM <table1>
INTERSECT
SELECT <sütun_adı>, <sütun_adı>...
FROM <table2>
```
### INTERSECT ALL

INTERSECT operatörü bize kesişen veriler içerisindeki tekrar edenleri göstermez. Tekrar edenleri görmek için **INTERSECT ALL** kullanırız.

### EXCEPT Kullanımı

**bookstore** veritabanında iki adet sorgu yapıyoruz. İlk sorgumuzda sayfa sayısı en fazla olan 5 kitabı, ikinci sorgumuzda ise isme göre 5 kitabı sıralıyoruz. EXCEPT
anahtar kelimesi sayesinde ilk sorguda olup ancak ikinci sorguda olmayan verileri gösterir.


```SQL
(
SELECT * 
FROM book
ORDER BY title
LIMIT 5
)
EXCEPT
(
SELECT * 
FROM book
ORDER BY page_number DESC
LIMIT 5
);
```
EXCEPT operatörü kullanılacağı sorguların, sütun sayıları eşit olmalıdır ve sütunlardaki veri tipleri eşleşmelidir.


### EXCEPT Söz Dizimi

```SQL
SELECT <sütun_adı>, <sütun_adı>...
FROM <table1>
EXCEPT
SELECT <sütun_adı>, <sütun_adı>...
FROM <table2>
```
### EXCEPT ALL

EXCEPT operatörü bize ilk sorguda olan ancak ikinci sorguda olmayan veriler içerisindeki tekrar edenleri göstermez. Tekrar edenleri görmek için
**EXCEPT ALL** kullanırız.

Alt Sorgular (Subqueries)
======
Bir sorgu içerisinde, o sorgunun ihtiyaç duyduğu veri veya verileri getiren sorgulardır.


### Alt Sorgu Kullanımı

**bookstore** veritabanında "Gülün Adı" isimli kitabımızın sayfa sayısı 466 dır. Bu kitaptan daha fazla sayıda sayfası bulunan kitapları aşağıdaki sorgu yardımıyla
sıralayabiliriz.

```SQL
SELECT *
FROM book
WHERE page_number > 466;
```
Ancak yukarıdaki sorgumuzda şöyle bir sorun var. 466 ifade statik bir ifade ve biz bu değeri bilmiyor olabiliriz. Bu nedenle buradaki 466 rakamını aşağıdaki sorgu
yardımıyla bulabiliriz.
```SQL
SELECT page_number
FROM book
WHERE title = 'Gülün Adı'
```

İşte bu ikinci sorgumuz ilk sorgumuzda bir alt sorgu görevi görebilir. Her iki sorguyu da birleştirelim.

```SQL
SELECT *
FROM book
WHERE page_number >
(
SELECT page_number
FROM book
WHERE title = 'Gülün Adı'
);
```


Any ve All Operatörleri
======
Any ve All operatörleri alt sorugularda sıklıkla kullanılır ve tek bir sütunda bulunan bir değerle bir değer dizisinin karşılaştırılmasını sağlar.


### ANY Operatörü

Alt sorgudan gelen herhangi bir değer koşulu sağlaması durumunda `TRUE` olarak ilgili değerin koşu sağlamasını sağlar.

**bookstore** veritabanında yapmış olduğumuz aşağıdaki sorguyu inceleyelim.

```SQL
SELECT first_name, last_name
FROM author
WHERE id = ANY
(
  SELECT id
  FROM book
  WHERE title = 'Abe Lincoln in Illinois' OR title = 'Saving Shiloh'
)
```
Yukarıda görmüş olduğunuz gibi alt sorgudan gelebilecek potansiye iki id değeri var, bu id değerinin her ikisi de birbirinden bağımsız olarak ana sorgudaki
id sütununda bulunan değerler ile eşleştiği için sorgu sonucunda oluşan sana tabloda id değeri 4 ve 5 olan yazarlara ait first_name ve last_name değerlerini
göreceğiz.

### ALL Operatörü

Alt sorgudan gelen tüm değerlerin koşulu sağlaması durumunda `TRUE` olarak döner.

**bookstore** veritabanındaki yine aynı sorguyu inceleyelim.

```SQL
SELECT first_name, last_name
FROM author
WHERE id = ALL
(
  SELECT id
  FROM book
  WHERE title = 'Abe Lincoln in Illinois' OR title = 'Saving Shiloh'
)
```
Burada ne söylemiştik alt sorgu tarafından 4 ve 5 id leri gelecek burada eştlik olduğu için aynı anda 4 ve 5 in bu şulu sağlaması olanaksız olduğu için
herhangi bir değer dönülmeyecektir.


Alt Sorgular ve JOIN Kullanımı
======
Altsorgular ve JOIN kavramları birlikte çok sık kullanılırlar. Aşağıdaki iki senaryoda bu iki yapıyı birlikte kullanacağız.

İlk senaryomuz: **bookstore** veri tabanında kitap sayfası sayısı ortalama kitap sayfası sayısından fazla olan kitapların isimlerini, bu kitapların yazarlarına ait isim ve soyisim
bilgileriyle birlikte sıralayınız.
```SQL
SELECT author.first_name, author.last_name, book.title
FROM author
INNER JOIN book ON book.author_id = author.id
WHERE page_number >
(
  SELECT AVG(page_number) FROM book
);

```

Yukarıdaki sorgumuzda kitaplara ait yazar bilgilerini JOIN kullanarak elde ediyoruz. Ortalama sayfa sayısını da alt sorgudan getiriyoruz.

İkinci senaryomuz: **dvdrental** veritabanında en uzun filmlerin isimlerini aktör isim ve soyisimleriyle birlikte sıralayalım.
```SQL
SELECT actor.first_name, actor.last_name, film.title
FROM actor
JOIN film_actor ON film_actor.actor_id = actor.actor_id
JOIN film ON film.film_id = film_actor.film_id
WHERE film.length =
(
  SELECT MAX(length)  FROM film
)

```
Burada da görmüş olduğumuz gibi film lerin aktör bilgilerini ikili JOIN yapısı kullanarak elde ediyoruz. En uzun film süresini de alt sorgudan
getiriyoruz.



<br>


# SQL Eğitim Patika

> #### Bu repo'da [Patika](https://academy.patika.dev/) SQL eğitiminde yapmış olduğum bütün ödevler bulunmaktadır.
>Örnek veritabanı [dvdrental](https://github.com/umithavare/Patika-SQL-Examples/blob/main/dvdrental.zip) linkinde bulunmaktadir. 

<br>

- ** SQL Ödev 01 | WHERE ve Karşılaştırma & Mantıksal
- ** SQL Ödev 02 | BETWEEN ve IN
- ** SQL Ödev 03 |  LIKE ve ILIKE
- ** SQL Ödev 04 | DISTINCT ve COUNT
- ** SQL Ödev 05 | ORDER BY | LIMIT ve OFFSET
- ** SQL Ödev 06 | Aggregate Fonksiyonlar
- ** SQL Ödev 07 | GROUP BY | HAVING
- ** SQL Ödev 08 | GROUP BY | HAVING
- ** SQL Ödev 09 | Tablo Oluşturma | Veri Güncelleme"
- ** SQL Ödev 10 | INNER JOIN
- ** SQL Ödev 11 | LEFT, RIGHT, FULL JOIN </a>**
- ** SQL Ödev 12 | UNION, INTERSECT ve EXCEPT


<br>

