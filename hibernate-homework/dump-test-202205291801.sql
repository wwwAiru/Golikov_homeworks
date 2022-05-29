--
-- PostgreSQL database dump
--

-- Dumped from database version 10.20
-- Dumped by pg_dump version 10.20

-- Started on 2022-05-29 18:01:01

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
-- TOC entry 196 (class 1259 OID 16884)
-- Name: departments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.departments (
    id integer NOT NULL,
    name character varying(255),
    max_salary integer,
    min_salary integer
);


ALTER TABLE public.departments OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16887)
-- Name: departments_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.departments_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.departments_id_seq OWNER TO postgres;

--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 197
-- Name: departments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.departments_id_seq OWNED BY public.departments.id;


--
-- TOC entry 198 (class 1259 OID 16889)
-- Name: details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.details (
    id integer NOT NULL,
    city character varying(255),
    email character varying(255),
    phone_number character varying(255)
);


ALTER TABLE public.details OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16895)
-- Name: details_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.details_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.details_id_seq OWNER TO postgres;

--
-- TOC entry 2850 (class 0 OID 0)
-- Dependencies: 199
-- Name: details_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.details_id_seq OWNED BY public.details.id;


--
-- TOC entry 200 (class 1259 OID 16897)
-- Name: employee_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_role (
    role_id integer NOT NULL,
    employee_id integer NOT NULL
);


ALTER TABLE public.employee_role OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16900)
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employees (
    id integer NOT NULL,
    name character varying(255),
    salary integer,
    surname character varying(255),
    department_id integer,
    details_id integer,
    create_at timestamp without time zone,
    update_at timestamp without time zone
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16906)
-- Name: employees_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employees_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employees_id_seq OWNER TO postgres;

--
-- TOC entry 2851 (class 0 OID 0)
-- Dependencies: 202
-- Name: employees_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.employees_id_seq OWNED BY public.employees.id;


--
-- TOC entry 203 (class 1259 OID 16908)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: bestuser
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO bestuser;

--
-- TOC entry 204 (class 1259 OID 16910)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16913)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO postgres;

--
-- TOC entry 2852 (class 0 OID 0)
-- Dependencies: 205
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- TOC entry 2696 (class 2604 OID 16915)
-- Name: departments id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departments ALTER COLUMN id SET DEFAULT nextval('public.departments_id_seq'::regclass);


--
-- TOC entry 2697 (class 2604 OID 16916)
-- Name: details id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.details ALTER COLUMN id SET DEFAULT nextval('public.details_id_seq'::regclass);


--
-- TOC entry 2698 (class 2604 OID 16917)
-- Name: employees id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees ALTER COLUMN id SET DEFAULT nextval('public.employees_id_seq'::regclass);


--
-- TOC entry 2699 (class 2604 OID 16918)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- TOC entry 2833 (class 0 OID 16884)
-- Dependencies: 196
-- Data for Name: departments; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.departments VALUES (3, 'Management', 80000, 10000);
INSERT INTO public.departments VALUES (1, 'Sales', 2500, 300);
INSERT INTO public.departments VALUES (2, 'IT', 5000, 800);


--
-- TOC entry 2835 (class 0 OID 16889)
-- Dependencies: 198
-- Data for Name: details; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.details VALUES (1, 'Penza', 'art@ya.ru', '+79054587961');
INSERT INTO public.details VALUES (2, 'Penza', 'olegrom@ya.ru', '+79374587354');
INSERT INTO public.details VALUES (3, 'Samara', 'dmital@gmail.com', '+79044587241');
INSERT INTO public.details VALUES (4, 'Samara', 'dmital@gmail.com', '+79044587241');
INSERT INTO public.details VALUES (5, 'Samara', 'dmital@gmail.com', '+79044587241');
INSERT INTO public.details VALUES (6, 'Samara', 'dmital@gmail.com', '+79044587241');
INSERT INTO public.details VALUES (7, 'Samara', 'dmital@gmail.com', '+79044587241');
INSERT INTO public.details VALUES (8, 'Samara', 'dmital@gmail.com', '+79044587241');


--
-- TOC entry 2837 (class 0 OID 16897)
-- Dependencies: 200
-- Data for Name: employee_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employee_role VALUES (1, 3);
INSERT INTO public.employee_role VALUES (2, 1);
INSERT INTO public.employee_role VALUES (2, 2);
INSERT INTO public.employee_role VALUES (2, 3);


--
-- TOC entry 2838 (class 0 OID 16900)
-- Dependencies: 201
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employees VALUES (2, 'Dmitriy', 1500, 'Alenkin', 2, 3, NULL, NULL);
INSERT INTO public.employees VALUES (3, 'Artem', 10000, 'Ivanov', 3, 1, NULL, NULL);
INSERT INTO public.employees VALUES (4, 'Alex
', 10000, 'Un', 2, 4, NULL, NULL);
INSERT INTO public.employees VALUES (5, 'Vasiliy1', 1000, 'Ivanov1', 1, 5, NULL, NULL);
INSERT INTO public.employees VALUES (6, 'Vasiliy2', 1355, 'Ivanov2', 1, 6, NULL, NULL);
INSERT INTO public.employees VALUES (7, 'Vasiliy3', 1212, 'Ivanov3', 1, 7, NULL, NULL);
INSERT INTO public.employees VALUES (8, 'Vasiliy4', 3542, 'Ivanov4', 2, 8, NULL, NULL);
INSERT INTO public.employees VALUES (1, 'Oleg', 900, 'Romanov', 1, 2, NULL, NULL);


--
-- TOC entry 2841 (class 0 OID 16910)
-- Dependencies: 204
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.roles VALUES (1, 'Admin');
INSERT INTO public.roles VALUES (2, 'User');


--
-- TOC entry 2853 (class 0 OID 0)
-- Dependencies: 197
-- Name: departments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.departments_id_seq', 5, true);


--
-- TOC entry 2854 (class 0 OID 0)
-- Dependencies: 199
-- Name: details_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.details_id_seq', 4, true);


--
-- TOC entry 2855 (class 0 OID 0)
-- Dependencies: 202
-- Name: employees_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employees_id_seq', 8, true);


--
-- TOC entry 2856 (class 0 OID 0)
-- Dependencies: 203
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: bestuser
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, true);


--
-- TOC entry 2857 (class 0 OID 0)
-- Dependencies: 205
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_seq', 3, true);


--
-- TOC entry 2701 (class 2606 OID 16920)
-- Name: departments departments_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departments
    ADD CONSTRAINT departments_pkey PRIMARY KEY (id);


--
-- TOC entry 2703 (class 2606 OID 16922)
-- Name: details details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.details
    ADD CONSTRAINT details_pkey PRIMARY KEY (id);


--
-- TOC entry 2705 (class 2606 OID 16924)
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);


--
-- TOC entry 2707 (class 2606 OID 16926)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 2710 (class 2606 OID 16927)
-- Name: employees fk235v8u05hy43side22iufopl1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT fk235v8u05hy43side22iufopl1 FOREIGN KEY (details_id) REFERENCES public.details(id);


--
-- TOC entry 2711 (class 2606 OID 16932)
-- Name: employees fkgy4qe3dnqrm3ktd76sxp7n4c2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT fkgy4qe3dnqrm3ktd76sxp7n4c2 FOREIGN KEY (department_id) REFERENCES public.departments(id);


--
-- TOC entry 2708 (class 2606 OID 16937)
-- Name: employee_role fko0j1qho7koleb1op32qsxrmog; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_role
    ADD CONSTRAINT fko0j1qho7koleb1op32qsxrmog FOREIGN KEY (role_id) REFERENCES public.roles(id);


--
-- TOC entry 2709 (class 2606 OID 16942)
-- Name: employee_role fkq7akog8jfl3sawo5upeq3x2fb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_role
    ADD CONSTRAINT fkq7akog8jfl3sawo5upeq3x2fb FOREIGN KEY (employee_id) REFERENCES public.employees(id);


-- Completed on 2022-05-29 18:01:01

--
-- PostgreSQL database dump complete
--

