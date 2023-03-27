insert into public.global_config_data("global_config") values (null);
INSERT INTO public.agent (global_config_id,"name","type") VALUES
    (1,'Agent1','AGENT');
INSERT INTO public."module" ("name","type",agent_id) VALUES
                                                         ('Module1','INPUT',1),
                                                         ('Module2','OUTPUT',1),
                                                         ('Module3','OUTPUT',1),
                                                         ('Module4','EXTENSION',1),
                                                         ('Module5','EXTENSION',1);
INSERT INTO public.route ("name",priority,agent_id) VALUES
                                                        ('Route1',1,1),
                                                        ('Route2',2,1),
                                                        ('Route3',3,1);
INSERT INTO public.module_route (module_id,route_id) VALUES
                                                         (1,1),
                                                         (2,1),
                                                         (3,1),
                                                         (4,1),
                                                         (5,1),
                                                         (1,2),
                                                         (2,2),
                                                         (3,2),
                                                         (4,2),
                                                         (5,2);
INSERT INTO public.module_route (module_id,route_id) VALUES
                                                         (1,3),
                                                         (2,3),
                                                         (3,3),
                                                         (4,3),
                                                         (5,3);
