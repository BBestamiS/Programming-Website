--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-04-29 08:49:14 +03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3270 (class 0 OID 24615)
-- Dependencies: 201
-- Data for Name: kullanici; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.kullanici (kullanici_id, isim, email, parola) FROM stdin;
12	Mehmet	mehmet123@hotmail.com	9876
15	Beyazıt	deneme@outlook.com	123
16	Ali	deneme@outlook.com	asd
\.


--
-- TOC entry 3274 (class 0 OID 32792)
-- Dependencies: 205
-- Data for Name: note; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.note (note_id, note) FROM stdin;
5	Aspect Ratio çocuğu belirli bir en boy oranına göre boyutlandırmaya çalışan bir widget.
\.


--
-- TOC entry 3272 (class 0 OID 32770)
-- Dependencies: 203
-- Data for Name: soru; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.soru (soru_id, soru, cevap_bir, cevap_iki, cevap_uc, cevap_dort, cevap_dogru) FROM stdin;
1	pubspec.yaml dosyası nedir?	Main fonksiyonunun bulunduğu dosyadır	Projenin konfigürasyon dosyasıdır	Tasarım oluşturmak için kullanılır	Projenin derlenmesini sağlar	2
2	Flutter kaç tür widget içerir?	1	2	3	4	2
3	Dart nedir?	Flutter uygulamaları geliştirmek için kullandığınız nesne yönelimli bir programlama dilidir.	Widgettir	Flutter derleyicisidir	Tasarım oluşturmamızı sağlar	1
4	Widget nedir?	Bir programlama dilidir	Veritabanı olarak kullanılır	Flutter derleyicisidir	Flutterda ki UI bileşenleridir	4
5	Stateless Widget ne işe yarar?	Ekrana görsel çizdirmeye yarar	Ekran ilk oluşturulduğunda bir kez çalışan widgetler üretmeyi sağlar	Fonksiyon oluşturmak için kullanılır	Veritabanı ile bağlantıyı sağlar	2
\.


--
-- TOC entry 3280 (class 0 OID 0)
-- Dependencies: 200
-- Name: kullanici_kullanici_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.kullanici_kullanici_id_seq', 16, true);


--
-- TOC entry 3281 (class 0 OID 0)
-- Dependencies: 204
-- Name: note_note_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.note_note_id_seq', 5, true);


--
-- TOC entry 3282 (class 0 OID 0)
-- Dependencies: 202
-- Name: soru_soru_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.soru_soru_id_seq', 5, true);


-- Completed on 2021-04-29 08:49:14 +03

--
-- PostgreSQL database dump complete
--

