PGDMP         *            
    x        
   distSystem    12.2    12.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    46773 
   distSystem    DATABASE     �   CREATE DATABASE "distSystem" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE "distSystem";
                postgres    false            �            1259    46774    form    TABLE     �  CREATE TABLE public.form (
    id bigint NOT NULL,
    run character varying(10) NOT NULL,
    first_name character varying(20) NOT NULL,
    last_name character varying(20) NOT NULL,
    last_name2 character varying(20) NOT NULL,
    reason_id bigint NOT NULL,
    email character varying(30) NOT NULL,
    user_id bigint NOT NULL,
    emitted_at timestamp without time zone NOT NULL,
    expired_at timestamp without time zone NOT NULL
);
    DROP TABLE public.form;
       public         heap    postgres    false            �            1259    46777    Form_id_seq    SEQUENCE     v   CREATE SEQUENCE public."Form_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public."Form_id_seq";
       public          postgres    false    202                        0    0    Form_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public."Form_id_seq" OWNED BY public.form.id;
          public          postgres    false    203            �            1259    46779    reason    TABLE     �   CREATE TABLE public.reason (
    id bigint NOT NULL,
    description character varying(30) NOT NULL,
    duration time without time zone NOT NULL
);
    DROP TABLE public.reason;
       public         heap    postgres    false            �            1259    46782    reason_id_seq    SEQUENCE     v   CREATE SEQUENCE public.reason_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.reason_id_seq;
       public          postgres    false    204            !           0    0    reason_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.reason_id_seq OWNED BY public.reason.id;
          public          postgres    false    205            �            1259    46784    user    TABLE     B  CREATE TABLE public."user" (
    first_name character varying(20) NOT NULL,
    last_name character varying(20) NOT NULL,
    last_name2 character varying(20) NOT NULL,
    password character varying(20) NOT NULL,
    email character varying(30) NOT NULL,
    run character varying(11) NOT NULL,
    id bigint NOT NULL
);
    DROP TABLE public."user";
       public         heap    postgres    false            �            1259    46787    user_id_seq    SEQUENCE     t   CREATE SEQUENCE public.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.user_id_seq;
       public          postgres    false    206            "           0    0    user_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.user_id_seq OWNED BY public."user".id;
          public          postgres    false    207            �
           2604    46789    form id    DEFAULT     d   ALTER TABLE ONLY public.form ALTER COLUMN id SET DEFAULT nextval('public."Form_id_seq"'::regclass);
 6   ALTER TABLE public.form ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202            �
           2604    46790 	   reason id    DEFAULT     f   ALTER TABLE ONLY public.reason ALTER COLUMN id SET DEFAULT nextval('public.reason_id_seq'::regclass);
 8   ALTER TABLE public.reason ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204            �
           2604    46791    user id    DEFAULT     d   ALTER TABLE ONLY public."user" ALTER COLUMN id SET DEFAULT nextval('public.user_id_seq'::regclass);
 8   ALTER TABLE public."user" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    207    206                      0    46774    form 
   TABLE DATA           }   COPY public.form (id, run, first_name, last_name, last_name2, reason_id, email, user_id, emitted_at, expired_at) FROM stdin;
    public          postgres    false    202   N                 0    46779    reason 
   TABLE DATA           ;   COPY public.reason (id, description, duration) FROM stdin;
    public          postgres    false    204   k                 0    46784    user 
   TABLE DATA           ]   COPY public."user" (first_name, last_name, last_name2, password, email, run, id) FROM stdin;
    public          postgres    false    206   �       #           0    0    Form_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public."Form_id_seq"', 1, false);
          public          postgres    false    203            $           0    0    reason_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.reason_id_seq', 5, true);
          public          postgres    false    205            %           0    0    user_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.user_id_seq', 1, false);
          public          postgres    false    207            �
           2606    46793    form Form_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.form
    ADD CONSTRAINT "Form_pkey" PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.form DROP CONSTRAINT "Form_pkey";
       public            postgres    false    202            �
           2606    46795    reason reason_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.reason
    ADD CONSTRAINT reason_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.reason DROP CONSTRAINT reason_pkey;
       public            postgres    false    204            �
           2606    46797    user user_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_pkey;
       public            postgres    false    206            �
           2606    46798    form reason_id    FK CONSTRAINT     z   ALTER TABLE ONLY public.form
    ADD CONSTRAINT reason_id FOREIGN KEY (reason_id) REFERENCES public.reason(id) NOT VALID;
 8   ALTER TABLE ONLY public.form DROP CONSTRAINT reason_id;
       public          postgres    false    2705    202    204            �
           2606    46803    form user_id    FK CONSTRAINT     v   ALTER TABLE ONLY public.form
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public."user"(id) NOT VALID;
 6   ALTER TABLE ONLY public.form DROP CONSTRAINT user_id;
       public          postgres    false    206    2707    202                  x������ � �         �   x�E��
1D��W���*�7o���6H�m�i��.,,�i����BO��x��� j��[Ml����-n	�Lz)��T�p�Rc���
v&V8!$�Jn��7z�8��p��i����Ш=����M�}��q.�         *   x�����/��E���9K!(�i ���\1z\\\ ڞ�     