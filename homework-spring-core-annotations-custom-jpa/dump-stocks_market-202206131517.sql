--
-- PostgreSQL database dump
--

-- Dumped from database version 10.20
-- Dumped by pg_dump version 10.20

-- Started on 2022-06-13 15:17:55

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

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 18568)
-- Name: account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account (
    id bigint NOT NULL,
    balance numeric(19,2),
    password character varying(255)
);


ALTER TABLE public.account OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 18573)
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    id integer NOT NULL,
    name character varying(255),
    account_id bigint
);


ALTER TABLE public.client OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 18578)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 2800 (class 0 OID 18568)
-- Dependencies: 196
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.account VALUES (2, 1729864.00, '64729');
INSERT INTO public.account VALUES (4, 1786386.00, '23432');
INSERT INTO public.account VALUES (6, 1596880.00, '32434');
INSERT INTO public.account VALUES (8, 1219520.00, '0955');
INSERT INTO public.account VALUES (10, 1143479.00, '1');
INSERT INTO public.account VALUES (12, 1170005.00, '3488');
INSERT INTO public.account VALUES (14, 1297648.00, '23232');


--
-- TOC entry 2801 (class 0 OID 18573)
-- Dependencies: 197
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.client VALUES (1, 'Андрей Голиков', 2);
INSERT INTO public.client VALUES (3, 'Игорь Алешин', 4);
INSERT INTO public.client VALUES (5, 'Елена Воробьёва', 6);
INSERT INTO public.client VALUES (7, 'John Carter', 8);
INSERT INTO public.client VALUES (9, 'Фёдор Конюхов', 10);
INSERT INTO public.client VALUES (11, 'Наталья Орлова', 12);
INSERT INTO public.client VALUES (13, 'Максим Орешкин', 14);


--
-- TOC entry 2809 (class 0 OID 0)
-- Dependencies: 198
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 14, true);


--
-- TOC entry 2675 (class 2606 OID 18572)
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);


--
-- TOC entry 2677 (class 2606 OID 18577)
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- TOC entry 2678 (class 2606 OID 18580)
-- Name: client fkisxed4kdvp061a3sweh6ml6pg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT fkisxed4kdvp061a3sweh6ml6pg FOREIGN KEY (account_id) REFERENCES public.account(id);


-- Completed on 2022-06-13 15:17:55

--
-- PostgreSQL database dump complete
--

