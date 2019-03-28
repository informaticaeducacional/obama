<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="tagSisInt" %>
<%@ taglib prefix="td" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<tags:layout>
    <jsp:attribute name="cabecalho">
        <style>
            button.btnAnchor {
                background: none !important;
                color: #039be5;
                border: none;
                padding: 0 !important;
                font: inherit;
                /*border is optional*/
                /*border-bottom:1px solid #039be5;*/
                cursor: pointer;
            }

            th {
                text-align: center;
            }

            td {
                text-align: center;
            }

        </style>

    </jsp:attribute>
    <jsp:attribute name="rodape">
        <script src="${ctx}/resources/plugins/dataTables/datatables.min.js"></script>
        <script src="${ctx}/resources/plugins/dataTables/Scroller-1.4.4/js/dataTables.scroller.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.16/js/dataTables.material.min.js"></script>
    </jsp:attribute>
    <jsp:body>
<form id="equipe" class="container-conteudo container scrollspy">
    <div  class="full-height">
        <div class="content-avatar ci">
            <div class="offset-m1 full-size">
                <div class="row">
                    <div class="col s12 center">
                        <label class="label-title">Coordenadores</label>
                    </div>
                    <div class="col s12 center" style="padding-top: 20px;">
                        <div class="col s6 l2 offset-l4">
                            <div class="display-avatar">

                                <!--  Avatar do colaborador -->
                                <div class="avatar-wrapper">
									<span class="k"><img
                                            src="${ctx}/resources/imagens/equipe/dennys.JPG" alt="Dennys Leite Maia (Coordenador)" />
									</span>
                                </div>

                                <!-- Link para abrir modal com mais informaÃ§Ãµes -->
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-dennys"><span class="fx">Dennys Leite Maia</span></a>
                                </div>

                                <!-- Modal com mais informaÃ§Ãµes -->
                                <div id="modal-dennys" class="modal">
                                    <div class="modal-content">
                                        <h4>Dennys Leite Maia</h4>
                                        <p>Pedagogo, Mestre em Educação e Doutor em Educação Brasileira. É Professor da
                                            Universidade Federal do Rio Grande do Norte (UFRN), atuante no Instituto
                                            Metrópole Digital (IMD), na Área de Tecnologia Educacional. Coordenador do
                                            Projeto Repositório de Objetos de Aprendizagem para Matemática (OBAMA). </p>
<!--                                         <p>Email: dennys@imd.ufrn.br</p> -->
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/4047293288281493" target="_blank">Currículo Lattes</a>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col s6 l2">
                            <div class="display-avatar">
                                <div class="avatar-wrapper">
									<span class="k"> <img
                                            src="${ctx}/resources/imagens/equipe/nelson.jpg" alt="Nelson Ion de Oliveira (Coordenador)" />
									</span>
                                </div>
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-nelson"> <span class="fx">Nelson Ion de Oliveira</span></a>
                                </div>
                                <div id="modal-nelson" class="modal">
                                    <div class="modal-content">
                                        <h4>Nelson Ion de Oliveira</h4>
                                        <p>Graduado em Análise e Desenvolvimento de Sistemas. Mestre em
                                            Sistemas e Computação da UFRN. É Professor da Universidade Federal do Rio
                                            Grande do Norte (UFRN), atuante no Instituto Metrópole Digital (IMD).
                                            Coordenador Adjunto do Projeto Repositório de Objetos de Aprendizagem para Matemática
                                            (OBAMA).</p>
<!--                                         <p>Email: nelson@imd.ufrn.br</p> -->
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/1886390007263393" target="_blank">Currículo Lattes</a>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s12 center">
                        <label class="label-title">Colaboradores</label>
                    </div>
                    <div class="col s12 center" style="padding-top: 20px;">
                        <div class="col s6 l2 membro-foto">
                            <div class="display-avatar">
                                <div class="avatar-wrapper">
									<span class="k"> <img
                                            src="${ctx}/resources/imagens/equipe/amanda.jpg" alt="" />
									</span>
                                </div>
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-amanda"> <span class="fx">Amanda Maria</span></a>
                                </div>
                                <div id="modal-amanda" class="modal">
                                    <div class="modal-content">
                                        <h4>Amanda Maria de Oliveira</h4>
                                        <p>Técnica em Tecnologia da Informação com ênfase em Desenvolvimento Web e 
                                         Bacharela em Tecnologia da Informação, ambos pela
                                            UFRN. É aluna do Programa de Pós-Graduação em Educação da UFRN, em nível de Mestrado, e atua como professora 
                                            da Escola Super Geeks. Membro do Projeto Repositório de Objetos de Aprendizagem para
                                            Matemática (OBAMA) como bolsista de iniciação científica.</p>
<!--                                         <p>Email: amanda.marry@hotmail.com</p> -->
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/3279011855900079" target="_blank">Currículo Lattes</a>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col s6 l2 membro-foto">
                            <div class="display-avatar">
                                <div class="avatar-wrapper">
									<span class="k"> <img
                                            src="${ctx}/resources/imagens/equipe/antonio.JPG" alt="" />
									</span>
                                </div>
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-antonio"> <span class="fx">Antônio Oliveira</span></a>
                                </div>
                                <div id="modal-antonio" class="modal">
                                    <div class="modal-content">
                                        <h4>Antônio Igor Silva de Oliveira</h4>
                                        <p>Graduado em Matemática Licenciatura e Mestre em Matemática. É Professor da Universidade Federal do Rio Grande do Norte (UFRN), atuante no Instituto
                                            Metrópole Digital (IMD).Membro do Projeto Repositório de Objetos de Aprendizagem para Matemática (OBAMA) como colaborador voluntário. </p>
<!--                                         <p>Email: igoroliveira@imd.ufrn.br</p> -->
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/7854426004893677" target="_blank">Currículo Lattes</a>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col s6 l2 membro-foto">
                            <div class="display-avatar">
                                <div class="avatar-wrapper">
									<span class="k"> <img
                                            src="${ctx}/resources/imagens/equipe/anaClaudia.jpg" alt="" />
									</span>
                                </div>
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-ana"> <span class="fx">Ana Cláudia</span></a>
                                </div>
                                <div id="modal-ana" class="modal">
                                    <div class="modal-content">
                                        <h4>Ana Cláudia Nunes da Silva</h4>
                                        <p>Estudante da Licenciatura em Pedagogia pela UFRN. Membro do Projeto
                                            Repositório de Objetos de Aprendizagem para Matemática (OBAMA) como colaboradora voluntária.</p>
<!--                                         <p>Email: anna.claudia.nunes@gmail.com</p> -->
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/9162268324293238" target="_blank">Currículo Lattes</a>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col s6 l2 membro-foto">
                            <div class="display-avatar">
                                <div class="avatar-wrapper">
                                    <a class="k"> <img
                                            src="${ctx}/resources/imagens/equipe/carmelia.JPG" alt="" />
                                    </a>
                                </div>
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-carmelia"> <span class="fx">Carmélia Regina</span></a>
                                </div>
                                <div id="modal-carmelia" class="modal">
                                    <div class="modal-content">
                                        <h4>Carmélia Regina Silva Xavier</h4>
                                        <p>Mestranda do Programa de Pós-graduação em Inovação em Tecnologias Educacionais (PPgITE) na 
                                        Universidade Federal do Rio Grande do Norte - UFRN, especialista em Educação de Jovens e Adultos 
                                        e graduada em Matemática, pela mesma Universidade. Atualmente é membro do Projeto Repositório de 
                                        Objetos de Aprendizagem para Matemática (OBAMA), professora do curso de Pedagogia da Universidade 
                                        Potiguar - UnP e assessora pedagógica da Secretaria Municipal de Educação de Natal/RN. 
                                        Tem experiência na área da Educação, em formação de professores com ênfase em Educação Matemática.</p>
                                        <p>Email: carmeliaxavierxavier@gmail.com</p>
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/0366500502646513" target="_blank">Currículo Lattes</a>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col s6 l2 membro-foto">
                            <div class="display-avatar">
                                <div class="avatar-wrapper">
                                    <a class="k"> <img
                                            src="${ctx}/resources/imagens/equipe/clesia.jpg" alt="" />
                                    </a>
                                </div>
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-clesia"> <span class="fx">Clésia Nunes</span></a>
                                </div>
                                <div id="modal-clesia" class="modal">
                                    <div class="modal-content">
                                        <h4>Clésia Jordania Nunes da Costa</h4>
                                        <p>Estudante da Licenciatura em Matemática pela UFRN. Membro do Projeto
                                            Repositório de Objetos de Aprendizagem para Matemática (OBAMA) como bolsista de extensÃ£o.</p>
<!--                                         <p>Email: clesiaj7@gmail.com</p> -->
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/1185440524755630" target="_blank">Currículo Lattes</a>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col s6 l2 membro-foto">
                            <div class="display-avatar">
                                <div class="avatar-wrapper">
									<span class="k"> <img
                                            src="${ctx}/resources/imagens/equipe/debora.JPG" alt="" />
									</span>
                                </div>
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-debora"> <span class="fx">Débora Karoline</span></a>
                                </div>
                                <div id="modal-debora" class="modal">
                                    <div class="modal-content">
                                        <h4>Débora Karoline Silva de Azevedo</h4>
                                        <p>Aluna do Bacharelado em Tecnologia da Informação. Membro do Projeto Repositório de Objetos de Aprendizagem para
                                            Matemática (OBAMA) como colaboradora voluntária.</p>
                                        <p>Email: deboraazevedoo@gmail.com</p>
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/9214856132183456" target="_blank">Currículo Lattes</a>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col s6 l2 membro-foto">
                            <div class="display-avatar">
                                <div class="avatar-wrapper">
									<span class="k"> <img
                                            src="${ctx}/resources/imagens/equipe/elvis.jpg" alt="" />
									</span>
                                </div>
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-elvis"> <span class="fx">Elvis Medeiros</span></a>
                                </div>
                                <div id="modal-elvis" class="modal">
                                    <div class="modal-content">
                                        <h4>Elvis Medeiros de Melo</h4>
                                        <p>Licenciado em Matemática e estudante do Bacharelado em Tecnologia da
                                            Informação e do Curso Técnico em Tecnologia da Informação com ênfase em
                                            Jogos Digitais (UFRN). Professor na rede privada de educação. Membro do
                                            Projeto Repositório de Objetos de Aprendizagem para Matemática (OBAMA) como bolsista voluntário de iniciação científica.</p>
                                        <p>Email: elvismedeiros.mm@gmail.com</p>
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/3022328816415300" target="_blank">Currículo Lattes</a>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>                    
                        
                        <div class="col s6 l2 membro-foto">
                            <div class="display-avatar">
                                <div class="avatar-wrapper">
									<span class="k"> <img
                                            src="${ctx}/resources/imagens/equipe/italo.JPG" alt="" />
									</span>
                                </div>
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-italo"> <span class="fx">Italo Hortiz</span></a>
                                </div>
                                <div id="modal-italo" class="modal">
                                    <div class="modal-content">
                                        <h4>Italo Hortiz do Nascimento</h4>
                                        <p>Aluno do Bacharelado em Tecnologia da Informação. Membro do Projeto Repositório de Objetos de Aprendizagem para
                                            Matemática (OBAMA) como bolsista voluntário de iniciação científica.</p>
                                        <p>Email: italohortiz2015@gmail.com</p>
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/1331329897162245" target="_blank">Currículo Lattes</a>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col s6 l2 membro-foto">
                            <div class="display-avatar">
                                <div class="avatar-wrapper">
                                    <a class="k"> <img
                                            src="${ctx}/resources/imagens/equipe/clara.JPG" alt="" />
                                    </a>
                                </div>
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-clara"> <span class="fx">Maria Clara</span></a>
                                </div>
                                <div id="modal-clara" class="modal">
                                    <div class="modal-content">
                                        <h4>Maria Clara Avelino dos Santo</h4>
                                        <p>Aluna do 5º período da Licenciatura Plena em Pedagogia pela UFRN e membro do Projeto 
                                        Repositório de Objetos de Aprendizagem para Matemática (OBAMA) como colaboradora.</p>
                                        <p>Email: claravelino2@gmail.com</p>
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/2583969973919219" target="_blank">Currículo Lattes</a>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col s6 l2 membro-foto">
                            <div class="display-avatar">
                                <div class="avatar-wrapper">
                                    <a class="k"> <img
                                            src="${ctx}/resources/imagens/equipe/mauro.JPG" alt="" />
                                    </a>
                                </div>
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-mauro"> <span class="fx">Mauro Cavalcante</span></a>
                                </div>
                                <div id="modal-mauro" class="modal">
                                    <div class="modal-content">
                                        <h4>Mauro Cavalcante de Souza Filho</h4>
                                        <p>Licenciado em Letras e Pós-graduado em Psicopedagogia e Orientação Educacional pela Universidade
                                        Federal Rural do Rio de Janeiro (UFRRJ). É professor na disciplina de literatura do curso Maughel e membro do Projeto 
                                        Repositório de Objetos de Aprendizagem para Matemática (OBAMA) como colaborador.</p>
                                        <p>Email: mcavalcante62@hotmail.com</p>
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/7072733793127772" target="_blank">Currículo Lattes</a>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col s6 l2 membro-foto">
                            <div class="display-avatar">
                                <div class="avatar-wrapper">
                                    <a class="k"> <img
                                            src="${ctx}/resources/imagens/equipe/luziene.JPG" alt="" />
                                    </a>
                                </div>
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-luziene"> <span class="fx">Maria Luziene</span></a>
                                </div>
                                <div id="modal-luziene" class="modal">
                                    <div class="modal-content">
                                        <h4>Maria Luziene Azevedo</h4>
                                        <p>Pedagoga. Professora da educação pública. Aluna do Programa de Pós Graduação
                                            em Inovação em Tecnologias Educacionais da UFRN (PPgITE).
                                            Membro do Projeto Repositório de Objetos de Aprendizagem para Matemática
                                            (OBAMA) como colaboradora voluntária.</p>
                                        <p>Email: mluzieneazevedo@gmail.com</p>
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/4736093339449585" target="_blank">Currículo Lattes</a>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col s6 l2 membro-foto">
                            <div class="display-avatar">
                                <div class="avatar-wrapper">
                                    <a class="k"> <img
                                            src="${ctx}/resources/imagens/equipe/rodolfo.jpg" alt="" />
                                    </a>
                                </div>
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-rodolfo"> <span class="fx">Rodolfo Carvalho</span></a>
                                </div>
                                <div id="modal-rodolfo" class="modal">
                                    <div class="modal-content">
                                        <h4>Rodolfo Araújo Carvalho</h4>
                                        <p>Técnico em Desenvolvimento WEB pelo Instituto Metrópole Digital (IMD). Aluno do
                                            Bacharelado em Tecnologia da Informação (UFRN) e líder no Grupo de
                                            Educadores Google - GEG Natal. Membro do Projeto Repositório de Objetos de Aprendizagem para Matemática
                                            (OBAMA) como bolsista voluntário de extensÃ£o.</p>
                                        <p>Email: rodolfooac@gmail.com</p>
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/3979982066078105" target="_blank">Currículo Lattes</a>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col s6 l2 membro-foto">
                            <div class="display-avatar">
                                <div class="avatar-wrapper">
									<span class="k"> <img
                                            src="${ctx}/resources/imagens/equipe/rodrigo.jpg" alt="" />
									</span>
                                </div>
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-rodrigo"> <span class="fx">Rodrigo Lima</span></a>
                                </div>
                                <div id="modal-rodrigo" class="modal">
                                    <div class="modal-content">
                                        <h4>Rodrigo Rodrigues Melo de Lima</h4>
                                        <p>Bacharel em Tecnologia da Informação (UFRN). Aluno do Programa de Pós Graduação
                                            em Inovação em Tecnologias Educacionais da UFRN (PPgITE).
                                            Membro do Projeto Repositório de Objetos de Aprendizagem para Matemática
                                            (OBAMA) como colaborador voluntário.</p>
                                        <p>Email: rodrigorodriguesml@gmail.com</p>
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/2677134128337820" target="_blank">Currículo Lattes</a>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col s6 l2 membro-foto">
                            <div class="display-avatar">
                                <div class="avatar-wrapper">
									<span class="k" >
										 <img src="${ctx}/resources/imagens/equipe/samuel.jpg" alt="" />
									</span>
                                </div>
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-samuel"> <span class="fx">Samuel Dantas</span></a>
                                </div>
                                <div id="modal-samuel" class="modal">
                                    <div class="modal-content">
                                        <h4>Samuel Dantas Batista</h4>
                                        <p>Aluno do Bacharelado em Tecnologia da Informação (UFRN). Membro do Projeto
                                            Repositório de Objetos de Aprendizagem para Matemática (OBAMA) como colaborador voluntário.
                                        </p>
<!--                                         <p>Email: samueldantas7@hotmail.com</p> -->
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/1782700263690294" target="_blank">Currículo Lattes</a>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col s6 l2 membro-foto">
                            <div class="display-avatar">
                                <div class="avatar-wrapper">
									<span class="k" >
										 <img src="${ctx}/resources/imagens/equipe/tullyo.JPG" alt="" />
									</span>
                                </div>
                                <div class="avatar-name center">
                                    <a class="modal-trigger" href="#modal-tullyo"> <span class="fx">Tullyo Santos</span></a>
                                </div>
                                <div id="modal-tullyo" class="modal">
                                    <div class="modal-content">
                                        <h4>Tullyo Gustavo dos Santos Silva</h4>
                                        <p>Estudante da Licenciatura em Pedagogia pela UFRN. Membro do Projeto
                                            Repositório de Objetos de Aprendizagem para Matemática (OBAMA) como bolsista voluntário de iniciação científica.
                                        </p>
<!--                                         <p>Email: tullyogustavo@hotmail.com</p> -->
                                        <div class="left">
                                            <a href="http://lattes.cnpq.br/4997637281579540" target="_blank">Currículo Lattes</a>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <a class="modal-action modal-close waves-effect btn-flat">Fechar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

    </jsp:body>
</tags:layout>