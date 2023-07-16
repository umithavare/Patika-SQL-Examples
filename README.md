# Patika-SQL-Examples
# Notes and assignments I took while learning sql.
* SQL declerative bir dildir.

* SQL, yapılandırılmış bir dildir ve belirli bir söz dizimine sahiptir. SQL kullanarak veritabanlarında sorgular yazabilir, veritabanı şemalarını oluşturabilir, veritabanı nesnelerini yönetebilir ve veritabanı işlemleri gerçekleştirebilirsiniz. SQL, farklı veritabanı yönetim sistemleri arasında genellikle taşınabilirlik sağlayan standart bir dil olarak kabul edilir, yani birçok veritabanı yönetim sistemi SQL'i destekler.

## WHERE KEYWORD

```RUBY
SELECT * FROM football_player WHERE Country == 'France';
```


```RUBY
SELECT * FORM film WHERE replacement_cost >= 12.99;
```

# WHERE AND LOGIC OPERATORS
* **AND** command'ini kullanarak sorgumuza ekleme yapip daha detayli yapabiliriz.


```RUBY
SELECT first_name, last_name FROM actor
WHERE first_name = 'Penelope' AND last_name = 'Monroe';
```

# AND, OR, NOT
* **AND** two condition must be true;
* **OR** if one of the conditions is true then the statement become true ;
* **NOT** it lists the excat opposite of the written statement;

```RUBY
SELECT * FROM film WHERE NOT (rental_rate >= 5.00 OR rental_rate = 2.99);
```

# BETWEEN ve IN
## BETWEEN
Aşağıdaki sorgumuzda AND mantıksal operatörü yardımıyla film tablosunda bulunan verilerimizi uzunluğu 140 tan küçük eşit VE 100 den büyük eşit olmak üzere sıralıyoruz.
```RUBY
SELECT * FROM film
WHERE length >= 100 AND length <= 140;
```
Burada temel olarak yaptığımız belirli aralıkta bulunan verileri sıralamak. Bunun BETWEEN ... AND yapısını kullanarak da yapabiliriz.

## BETWEEN AND Söz Dizimi
```RUBY
SELECT <sütun_adı>, <sütun_adı>, ... FROM <tablo_adı>
WHERE <koşul>;
```
## BETWEEN Örnek Kullanım
```RUBY
SELECT * FROM film
WHERE length BETWEEN 100 AND 140; -- WHERE length >= 100 AND length <= 140 ifadesi ile aynı sonucu verir.
```
Burada dikkat edilmesi gereken nokta 100 ve 140 sınır değerleri aralığa dahildir.

## IN
Şöyle bir senaryo düşünelim, yine film tablosundan uzunluğu 30, 60, 90 veya 120 dakikaya eşit olan verileri sıralayalım.
```RUBY
SELECT * FROM film
WHERE length = 30 OR length = 60 OR length = 90 OR length = 120;
```
sorgusuyla verileri aldık ancak burada şöyle bir sorunumuz var peki 4 farklı değer için değil 14 farklı değer için bu sorgumuzu gerçekleştirmek için 14 ayrı OR mantıksal operatörü kullanmamız gerekirdi. Bunun yerine istenilen değerleri liste haline geitip IN anahtar kelimesiyle kullanabiliriz.

## IN Söz Dizimi
```RUBY
SELECT <sütun_adı>, <sütun_adı>, ... FROM <tablo_adı>
WHERE <sütun_adı> IN (değer1, değer2, ...);
```
## IN Örnek Kullanım
```RUBY
SELECT * FROM film
WHERE length IN (30,60,90,120);
```
# LIKE ve ILIKE
Aşağıdaki sorgumuzda actor tablomuzda bulunan tüm sütunlardaki verileri first_name sütununda ki değeri 'Penelope' olmak üzere getiriyoruz.
```RUBY
SELECT *
FROM actor
WHERE first_name = 'Penelope';
```
Ancak bizler bazı durumlarda bu şekilde tam eşleşme değil belirli şablonlara uyan koşulların sağlanmasını isteriz. Örneğin aşağıdaki sorgumuzda first_name sütunun 'Penelope' değerine eşit olmasını değil, ilk harfin 'P' olması koşulunu sağlar. Bunun için LIKE operatörünü kullanırız.

```RUBY
SELECT *
FROM actor
WHERE first_name LIKE 'P%';
```
Burada kullanılan % karakteri sıfır, bir veya daha fazla karakteri temsil eder ve Wildcard olarak isimlendirilir. Bir diğer wildcard karakteri _ karakteridir ve bir karakteri temsil eder.

## LIKE Söz Dizimi
```RUBY
SELECT <sütun_adı>, <sütun_adı>, ...
FROM <tablo_adı>
WHERE <sütun_adı> LIKE <şablon>;
```
ILIKE operatörü LIKE operatörünün case - insensitive versiyonudur.

<br>
<br>



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

