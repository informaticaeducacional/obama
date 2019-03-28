<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" uri="tagSisInt"%>
<%@ taglib prefix="td" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<tags:layout>
	<jsp:attribute name="cabecalho">       
    </jsp:attribute>
	<jsp:attribute name="rodape">
        <script
			src="${ctx}/resources/plugins/dataTables/datatables.min.js"></script>
        <script
			src="${ctx}/resources/plugins/dataTables/Scroller-1.4.4/js/dataTables.scroller.min.js"></script>
        <script
			src="https://cdn.datatables.net/1.10.16/js/dataTables.material.min.js"></script>
    </jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="row">
				<tags:card-obama titulo="Publicações">
					<div class="row">
						<div class="col s12">
							<label>Aqui você pode encontrar as publicações que foram feitas
								pelos integrantes do Obama em congressos!</label>
							<ul class="collapsible popout" data-collapsible="accordion">
								<li class="collapsable-publi">
									<div class="collapsible-header">
										<i class="material-icons blue-text">import_contacts</i>OBAMA:
										um Repositório de Objetos de Aprendizagem para Matemática
									</div>
									<div class="collapsible-body">
										<span>Autores: Samuel Batista, Rodolfo Carvalho, Amanda
											Maria Oliveira, Dennys Maia, Nelson Oliveira, Anna Claudia
											Nunes Silva.</span> <br /> <br /> <span> Resumo: Este artigo
											apresenta o protótipo da segunda versão do repositório Objetos
											de Aprendizagem para Matemática (OBAMA). Atualmente, o OBAMA
											2.0 disponibiliza 514 objetos de aprendizagem (OA) para
											Matemática. Os OA acessíveis pelo OBAMA contemplam tanto
											dispositivos desktop quanto mobile e estão classificados
											considerando aspectos técnicos e pedagógicos. O OBAMA 2.0
											possui sistema de busca por OA por título, níveis de ensino da
											Educação Básica, temas curriculares da Matemática e
											descritores. Com essas caracterísitcas, esperamos contribuir
											para a prática de professores que ensinam Matemática e desejam
											integrar OA em suas práticas de ensino. </span>
										<p>
											Texto completo disponível <a target="_blank"
												href="http://www.br-ie.org/pub/index.php/wcbie/article/view/7400/5196">aqui</a>.
										</p>
									</div>			
								</li>
	
								<li class="collapsable-publi">
									<div class="collapsible-header">
										<i class="material-icons blue-text">import_contacts</i>Recursos
										educativos digitais para Educação Matemática: um levantamento
										para dispositivos móveis.
									</div>
									<div class="collapsible-body">
										<span>Autores: MELO, E. M.; COSTA, C. J. N. ; MAIA, D.
											L.</span> <br /> <br /> <span>Resumo: Diante das
											dificuldades enfrentadas para a apreensão de conceitos
											Matemáticos, práticas e recursos são desenvolvidos. Com a
											disseminação dos smartphones, esforços são empreendidos também
											no desenvolvimento de recursos educativos para dispositivos
											móveis. Este trabalho objetiva apresentar o processo de busca,
											catalogação e classificação de recursos educativos digitais
											para dispositivos móveis incluídos em um repositório.
											Encontramos 184 apps e os classificamos de acordo com os temas
											de Matemática da Prova Brasil. Concluída a classificação, 105
											apps catalogados eram relacionados à Álgebra e 27 não se
											aplicavam à nenhuma categoria. </span>
										<p>
											Texto completo <a target="_blank"
												href="http://ceur-ws.org/Vol-1877/CtrlE2017_AC_40_46.pdf">aqui</a>.
										</p>
									</div>
								</li>
	
								<li class="collapsable-publi">
									<div class="collapsible-header">
										<i class="material-icons blue-text">import_contacts</i>Levantamento
										e catalogação de objetos de aprendizagem para Matemática para
										atualização de um repositório
									</div>
									<div class="collapsible-body">
										<span>Autores: OLIVEIRA, Amanda Maria Domingos de ;
											SILVA, Ana Claudia Nunes ; COSTA, Clesia Jordania Nunes da ;
											MAIA, Dennys Leite.</span> <br /> <br /> <span>Resumo: Este
											trabalho relata o processo de levantamento e catalogação de
											Objetos de Aprendizagem (OA) para Matemática como atualização
											do repositório de Objetos de Aprendizagem para Matemática
											(OBAMA). Para isso, foi realizada uma revisão quanto à
											disponibilidade e continuidade dos OA já constantes na
											primeira versão do repositório e o levantamento ecatalogação
											de novos OA disponíveis em outros repositórios. Foram
											catalogados 133 novos OA, organizados em etapas de ensino da
											Educação Básica. A atualização e catalogação de novos OA
											ampliou em cerca de 50% o acervo de OA para Matemática do
											repositório, que já contava com 261 OA catalogados por etapa
											de ensino e tema curricular. </span>
										<p>
											Texto completo <a target="_blank"
												href="http://ceur-ws.org/Vol-1877/CtrlE2017_AC_04_119.pdf">aqui</a>.
										</p>
									</div>
								</li>
	
								<li class="collapsable-publi">
									<div class="collapsible-header">
										<i class="material-icons blue-text">import_contacts</i>Reconstrução
										de um repositório de objetos de aprendizagem para Matemática
									</div>
									<div class="collapsible-body">
										<span>Autores: BATISTA, S. D. ; OLIVEIRA, A. M. D. ;
											MELO, E. M. ; BRITO, D. T. S. ; OLIVEIRA, N. I. ; MAIA, D. L.
										</span> <br /> <br /> <span>Resumo: Este artigo propõe
											relatar o design do processo de atualização de um repositório
											de objetos de aprendizagem para Matemática. O repositório
											propõe agregar grandes quantidades de OA que possam contribuir
											para a aprendizagem de conceitos matemáticos. Para isso,
											definimos a utilização de uma linguagem de modelagem de
											projetos para apresentação da proposta. Foi elaborado um
											diagrama de classes, que define os objetos a serem
											implementados e um diagrama de caso de uso, que demonstra os
											tipos usuários e suas funcionalidades, com a finalidade
											planejar e documentar o processo de desenvolvimento. O
											repositório encontra-se em fase de implementação e,
											futuramente, será testado em uma formação de professores. </span>
										<p>
											Texto completo <a target="_blank"
												href="http://ceur-ws.org/Vol-1877/CtrlE2017_AC_05_121.pdf">aqui</a>.
										</p>
									</div>
								</li>
	
								<li class="collapsable-publi">
									<div class="collapsible-header">
										<i class="material-icons blue-text">import_contacts</i>Objetos
										de aprendizagem para Matemática: yes we can!
									</div>
									<div class="collapsible-body">
										<span>Autores: MAIA, D. L. ; OLIVEIRA, A. M. D. ; COSTA,
											C. J. N. ; MELO, E. M. ; OLIVEIRA, N. I. ; BRITO, D. T. S. ;
											BATISTA, S. D. ; SILVA, A. C. N. </span> <br /> <br /> <span>Resumo:
											Objetos de aprendizagem (OA) contribuem para diversificar as
											práticas de ensino e promover aprendizagem. Entretanto, é
											preciso que estes recursos sejam conhecidos e apropriados
											pelos docentes para que possam ser integrados às aulas,
											sobretudo em áreas com baixos índices de proficiência, como é
											a Matemática. Nesse sentido, o Projeto Objetos de Aprendizagem
											para Matemática (OBAMA) desenvolveu e atualizou um repositório
											com 578 OA, do tipo animação e simulação, para trabalhar
											conteúdos matemáticos da Educação Básica. Os OA disponíveis no
											OBAMA contemplam, além de recursos para desktop, apps para
											dispositivos móveis. Para facilitar a busca e escolha pelos
											docentes, os OA foram classificados pelo nível de ensino a
											qual foram planejados, temas de conteúdo e habilidades
											matemáticas, listados na matriz de descritores da Prova
											Brasil. </span>
										<p>
											Texto completo <a target="_blank"
												href="http://ceur-ws.org/Vol-1877/CtrlE2017_MC_10.pdf">aqui</a>.
										</p>
									</div>
								</li>
	
								<li class="collapsable-publi">
									<div class="collapsible-header">
										<i class="material-icons blue-text">import_contacts</i>Avaliação
										de classificação de recursos educativos digitais para o
										ensino e aprendizagem de matemática para dispositivos móveis.
									</div>
									<div class="collapsible-body">
										<span>Autores: MELO, E. M.; COSTA, C. J. N. ; MAIA, D.
											L. </span> <br /> <br /> <span>Resumo: O uso de Objetos de
											Aprendizagem (OA) contribui para diversificar as situações de
											ensino e aprendizagem por oportunizar distintas formas de
											representar e manipular o pensamento matemático. Com a
											disseminação dos smartphones, esforços são empreendidos também
											para o desenvolvimento de recursos educativos para
											dispositivos móveis que possa fornecer subsídios para a
											concepção e desenvolvimento de ferramentas para a busca e uso
											desses recursos. Este trabalho objetiva apresentar o processo
											de busca, catalogação e classificação de recursos educativos
											digitais para dispositivos móveis incluídos no repositório de
											Objetos de Aprendizagem para Matemática (OBAMA 2.0).
											Contribuímos com aspectos pedagógicos para o uso das
											Tecnologias Digitais de Informação e Comunicação para
											Matemática na reestruturação do OBAMA 2.0, além de colaborar
											para uma formação de professores sobre OA para o ensino de
											Matemática. Usamos metodologia quantitativa e qualitativa
											devido à natureza dos dados. Catalogamos 134 novos OA para
											desktop que foram classificados quanto ao nível de ensino,
											blocos de conteúdos e descritores. Para mobile, encontramos
											184 apps e os classificamos de acordo com os temas de
											Matemática da Prova Brasil. A colaboração na formação de
											professores com o OBAMA 2.0 foi importante para a consolidação
											da pesquisa, assim como a participação em eventos da área.
											Dentre os resultados, encontramos poucos recursos
											desenvolvidos para o Tratamento de Informação em relação à
											outros temas. </span>
										<p>
											Texto completo <a target="_blank"
												href="http://www.cic.propesq.ufrn.br/anais.php">aqui</a>.
										</p>
									</div>
								</li>
	
	
								<li class="collapsable-publi">
									<div class="collapsible-header">
										<i class="material-icons blue-text">import_contacts</i>Reconstrução
										de um Repositório de Objetos de Aprendizagem para Matemática
									</div>
									<div class="collapsible-body">
										<span>Autores: OLIVEIRA, A. M. D. ; BATISTA, S. D. ;
											MAIA, D. L. </span> <br /> <br /> <span>Resumo: Este
											trabalho apresenta o processo de reconstrução de um
											Repositório de Objetos de Aprendizagem para Matemática
											(OBAMA). O repositório OBAMA, desde sua concepção, busca ser
											uma fonte para professores da Educação Básica terem acesso a
											Objetos de Aprendizagem (OA) para Matemática. Foi necessária
											sua reconstrução para implementação de novas funcionalidades e
											melhorias no processo de busca e apresentação dos OA. O
											projeto de reconstrução teve início com o planejamento do
											OBAMA enquanto software, a partir de diagramas e projeto de
											interface gráfica, seguindo com a definição das tecnologias a
											serem utilizadas e então a implementação do que foi definido
											para a nova versão do repositório e o teste diretamente com o
											público-alvo, professores que ensinam matemática. </span>
										<p>
											Texto completo <a target="_blank"
												href="http://arquivos.info.ufrn.br/arquivos/2017007125e7d645406983059147f7ee2/Anais_eCICT_2017.pdf">aqui</a>.
										</p>
									</div>
								</li>
	
	
								<li class="collapsable-publi">
									<div class="collapsible-header">
										<i class="material-icons blue-text">import_contacts</i>Atualização
										e (re)desenvolvimento de um Repositório de Objetos de
										Aprendizagem para Matemática (OBAMA)
									</div>
									<div class="collapsible-body">
										<span>Autores: BATISTA, S. D. ; OLIVEIRA, A. M. D. ;
											MAIA, D. L. </span> <br /> <br /> <span>Resumo: Este
											trabalho propõe relatar o processo desenvolvimento um
											repositório de objetos de aprendizagem para Matemática. O
											repositório foi planejado por meio de uma linguagem de
											modelagem de projeto e desenvolvido em Java. Para documentar o
											sistema foi elaborado um diagrama de classes, que define os
											objetos a serem implementados e um diagrama de caso de uso,
											que demonstra os tipos usuários e suas funcionalidades. O
											repositório apresenta 514 OA para o ensino da Matemática.</span>
										<p>
											Texto completo <a target="_blank"
												href="http://arquivos.info.ufrn.br/arquivos/2017007125e7d645406983059147f7ee2/Anais_eCICT_2017.pdf">aqui</a>.
										</p>
									</div>
								</li>
	
								<li class="collapsable-publi">
									<div class="collapsible-header">
										<i class="material-icons blue-text">import_contacts</i>A
										inserção de descritores de Tratamento da Informação na
										classificação de recursos educativos digitais de um
										repositório.
									</div>
									<div class="collapsible-body">
										<span>Autores: MELO, Elvis Medeiros de ; COSTA, Clesia
											Jordania Nunes da ; MAIA, Dennys Leite. </span> <br /> <br /> <span>Resumo:
											O descritor é uma minúcia de uma habilidade cognitiva que está
											relacionado a um conteúdo estudado em determinada etapa de
											ensino. O Tratamento da Informação (TI) trata-se de um
											conteúdo da matemática recorrente na vida dos estudantes que
											pode ser trabalhado de forma interdisciplinar. Alinhado à
											essas ideias, este artigo tem o objetivo de analisar Objetos
											de Aprendizagem disponibilizados em um repositório para o
											bloco de conteúdo do TI, usando como base descritores da Prova
											Brasil. Dos 330 recursos classificados, 38 foram considerados
											para TI. Eles foram disponibilizados em um repositório, o
											OBAMA, oferecendo ao professor um recurso mais rico de
											características. Com a análise dos resultados, destacamos a
											pouca quantidade recursos desenvolvidos e poucos descritores
											para atividades específicas do TI. </span>
										<p>
											Texto completo <a target="_blank"
												href="http://arquivos.info.ufrn.br/arquivos/2017007125e7d645406983059147f7ee2/Anais_eCICT_2017.pdf">aqui</a>.
										</p>
									</div>
								</li>
							</ul>
						</div>
					</div>						
	            </tags:card-obama>
			</div>
		</div>
    </jsp:body>
</tags:layout>