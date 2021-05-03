--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-04-29 08:43:46 +03

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 201 (class 1259 OID 24615)
-- Name: kullanici; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.kullanici (
    kullanici_id integer NOT NULL,
    isim character varying NOT NULL,
    email character varying NOT NULL,
    parola character varying NOT NULL
);


ALTER TABLE public.kullanici OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 24613)
-- Name: kullanici_kullanici_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.kullanici_kullanici_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.kullanici_kullanici_id_seq OWNER TO postgres;

--
-- TOC entry 3274 (class 0 OID 0)
-- Dependencies: 200
-- Name: kullanici_kullanici_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.kullanici_kullanici_id_seq OWNED BY public.kullanici.kullanici_id;


--
-- TOC entry 205 (class 1259 OID 32792)
-- Name: note; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.note (
    note_id integer NOT NULL,
    note character varying NOT NULL
);


ALTER TABLE public.note OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 32790)
-- Name: note_note_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.note_note_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.note_note_id_seq OWNER TO postgres;

--
-- TOC entry 3275 (class 0 OID 0)
-- Dependencies: 204
-- Name: note_note_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.note_note_id_seq OWNED BY public.note.note_id;


--
-- TOC entry 203 (class 1259 OID 32770)
-- Name: soru; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.soru (
    soru_id integer NOT NULL,
    soru character varying NOT NULL,
    cevap_bir character varying NOT NULL,
    cevap_iki character varying NOT NULL,
    cevap_uc character varying NOT NULL,
    cevap_dort character varying NOT NULL,
    cevap_dogru character varying NOT NULL
);


ALTER TABLE public.soru OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 32768)
-- Name: soru_soru_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.soru_soru_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.soru_soru_id_seq OWNER TO postgres;

--
-- TOC entry 3276 (class 0 OID 0)
-- Dependencies: 202
-- Name: soru_soru_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.soru_soru_id_seq OWNED BY public.soru.soru_id;


--
-- TOC entry 3130 (class 2604 OID 24618)
-- Name: kullanici kullanici_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kullanici ALTER COLUMN kullanici_id SET DEFAULT nextval('public.kullanici_kullanici_id_seq'::regclass);


--
-- TOC entry 3132 (class 2604 OID 32795)
-- Name: note note_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.note ALTER COLUMN note_id SET DEFAULT nextval('public.note_note_id_seq'::regclass);


--
-- TOC entry 3131 (class 2604 OID 32773)
-- Name: soru soru_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soru ALTER COLUMN soru_id SET DEFAULT nextval('public.soru_soru_id_seq'::regclass);


--
-- TOC entry 3134 (class 2606 OID 24623)
-- Name: kullanici kullanici_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kullanici
    ADD CONSTRAINT kullanici_pkey PRIMARY KEY (kullanici_id);


--
-- TOC entry 3138 (class 2606 OID 32800)
-- Name: note note_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.note
    ADD CONSTRAINT note_pkey PRIMARY KEY (note_id);


--
-- TOC entry 3136 (class 2606 OID 32778)
-- Name: soru soru_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soru
    ADD CONSTRAINT soru_pkey PRIMARY KEY (soru_id);


-- Completed on 2021-04-29 08:43:47 +03

--
-- PostgreSQL database dump complete
--

