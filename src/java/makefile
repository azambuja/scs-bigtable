SHELL := bash
SCS_DIR := .
UNAME := `uname`
WEKADIR = ../../lib/
JAR_WEKA = $(WEKADIR)/weka.jar
JAVA_HOME = /usr/bin/

# ==========================================================================
# ======= CLASSPATH ========================================================
# ==========================================================================

PATHS :=  \
	$(JAR_WEKA)
   
UNIX_CLASSPATH := $(foreach path, $(PATHS), $(path):)
UNIX_CLASSPATH += .

ifdef WINDIR
  TMP_CLASSPATH := $(subst :,\\;,"$(UNIX_CLASSPATH)")
  CLASSPATH := $(TMP_CLASSPATH)
else
  CLASSPATH := $(UNIX_CLASSPATH)
endif
CLASSPATH := $(shell echo $(CLASSPATH) | tr -d " ")
export CLASSPATH

# ==========================================================================
# ======== Pacotes do SCS ===============================================
# ==========================================================================
# Os pacotes n�o s�o percorridos recursivamente, portanto sub-pacotes tem que
# ser explicitamente declarados !!!

# ======== CORE ==========================================================
PACKAGES_SCS_CORE :=  \
  scs/core \
  scs/core/servant \
  scs/event_service \
  scs/event_service/servant 
 
# geraa��o dos paths
PACKAGES_SCS_CORE := $(addprefix $(SCS_DIR)/, $(PACKAGES_SCS_CORE))
# arquivos .java em cada pacote
SCS_CORE_SRC_FILES := $(foreach p, $(PACKAGES_SCS_CORE), $(wildcard $(p)/*.java))

# ======== EXECUTION NODE ==========================================================
PACKAGES_SCS_EXECUTION_NODE := \
  scs/execution_node \
  scs/execution_node/servant 

# gera��o dos paths
PACKAGES_SCS_EXECUTION_NODE  := $(addprefix $(SCS_DIR)/, $(PACKAGES_SCS_EXECUTION_NODE))
# arquivos .java em cada pacote
SCS_EXECUTION_NODE_SRC_FILES := $(foreach p, $(PACKAGES_SCS_EXECUTION_NODE), $(wildcard $(p)/*.java))

# ======== CONTAINER ==========================================================
PACKAGES_SCS_CONTAINER := \
   scs/instrumentation \
   scs/instrumentation/app \
   scs/instrumentation/servant \
   scs/instrumentation/interceptor \
   scs/container \
   scs/container/servant
 
# gera��o dos paths
PACKAGES_SCS_CONTAINER  := $(addprefix $(SCS_DIR)/, $(PACKAGES_SCS_CONTAINER))
# arquivos .java em cada pacote
SCS_CONTAINER_SRC_FILES := $(foreach p, $(PACKAGES_SCS_CONTAINER), $(wildcard $(p)/*.java))

# ======== REASONING ==========================================================
PACKAGES_SCS_REASONING := \
    scs/reasoning \
    scs/reasoning/servant \
    scs/reasoning/app/    

# gera��o dos paths
PACKAGES_SCS_REASONING  := $(addprefix $(SCS_DIR)/, $(PACKAGES_SCS_REASONING))
# arquivos .java em cada pacote
SCS_REASONING_SRC_FILES := $(foreach p, $(PACKAGES_SCS_REASONING), $(wildcard $(p)/*.java))


# ======== DEMO APPLICATIONS==============================================
PACKAGES_SCS_PINGPONG := \
    scs/demos/pingpong \
    scs/demos/pingpong/servant 
# gera��o dos paths
PACKAGES_SCS_PINGPONG := \
  $(addprefix $(SCS_DIR)/, $(PACKAGES_SCS_PINGPONG))
# arquivos .java em cada pacote
SCS_PINGPONG_SRC_FILES := \
  $(foreach p, $(PACKAGES_SCS_PINGPONG), $(wildcard $(p)/*.java))

PACKAGES_SCS_PHILOSOPHER := \
    scs/demos/philosopher \
    scs/demos/philosopher/servant 
# gera��o dos paths
PACKAGES_SCS_PHILOSOPHER := \
  $(addprefix $(SCS_DIR)/, $(PACKAGES_SCS_PHILOSOPHER))
# arquivos .java em cada pacote
SCS_PHILOSOPHER_SRC_FILES := \
  $(foreach p, $(PACKAGES_SCS_PHILOSOPHER), $(wildcard $(p)/*.java))

PACKAGES_SCS_CHAT := \
     scs/demos/chat
# gera��o dos paths
PACKAGES_SCS_CHAT := \
  $(addprefix $(SCS_DIR)/, $(PACKAGES_SCS_CHAT))
# arquivos .java em cada pacote
SCS_CHAT_SRC_FILES := \
  $(foreach p, $(PACKAGES_SCS_CHAT), $(wildcard $(p)/*.java))

PACKAGES_SCS_MAPREDUCE := \
     scs/demos/mapreduce \
     scs/demos/mapreduce/schedule \
     scs/demos/mapreduce/servant \
     scs/demos/mapreduce/app \
     scs/demos/mapreduce/user	

PACKAGES_SCS_BIGTABLE := \
     scs/demos/bigtable \
     scs/demos/bigtable/app \
     scs/demos/bigtable/servant \
     scs/demos/bigtable/test \
     scs/demos/bigtable/test/servant	

# gera��o dos paths
PACKAGES_SCS_MAPREDUCE := \
  $(addprefix $(SCS_DIR)/, $(PACKAGES_SCS_MAPREDUCE))
# arquivos .java em cada pacote
SCS_MAPREDUCE_SRC_FILES := \
  $(foreach p, $(PACKAGES_SCS_MAPREDUCE), $(wildcard $(p)/*.java))

PACKAGES_SCS_BIGTABLE := \
  $(addprefix $(SCS_DIR)/, $(PACKAGES_SCS_BIGTABLE))
# arquivos .java em cada pacote
SCS_BIGTABLE_SRC_FILES := \
  $(foreach p, $(PACKAGES_SCS_BIGTABLE), $(wildcard $(p)/*.java))

# ==========================================================================
# ==========================================================================

# Pacote idl

IDL_DIR = ../../idl

IDL_CMD := idlj -fallTIE -I $(IDL_DIR) 

# ==========================================================================
# ==========================================================================

# Jars do SCS
SCS_JARS = \
  $(JAR_SCS_CORE) \
  $(JAR_SCS_EXECUTION_NODE) \
  $(JAR_SCS_CONTAINER)

# Diret�rio com os jars dos pacotes SCS.
SCS_JARS_DIR := ../../package

#Diretorio onde se encontram os manifestos dos arquivos jar
MANIFEST_DIR := ../../scripts/build

# Pacote com toda hierarquia CORE do SCS.
JAR_SCS_CORE := $(SCS_JARS_DIR)/core.jar

# Pacote Execution Node.
JAR_SCS_EXECUTION_NODE := $(SCS_JARS_DIR)/executionNode.jar

# Pacote Container.
JAR_SCS_CONTAINER := $(SCS_JARS_DIR)/container.jar

# Pacote com a demo pingpong.
JAR_SCS_PINGPONG := $(SCS_JARS_DIR)/pingPong.jar

# ==========================================================================

all: \
  presentation \
  just-compile \
  done

just-compile: \
    idl-generation \
    scs-pkg \
    scs-jars 

source-files:
	@echo " # Arquivos-fonte java do projeto SCS: "
	@echo "Core: $(SCS_CORE_SRC_FILES)"
	@echo "Execution Node: $(SCS_EXECUTION_NODE_SRC_FILES)"
	@echo "Container: $(SCS_CONTAINER_SRC_FILES)"
	@echo "Reasoning: $(SCS_REASONING_SRC_FILES)"
	@echo " "
	@echo "Aplicacoes Demo:"
	@echo "Philosophers: $(SCS_PHILOSOPHER_SRC_FILES)"
	@echo "Chat: $(SCS_CHAT_SRC_FILES)"
	@echo "MapReduce: $(SCS_MAPREDUCE_SRC_FILES)"
	@echo "BigTable: $(SCS_BIGTABLE_SRC_FILES)"

done:
	@echo " # SCS compilado com sucesso"

presentation:
	@echo ""
	@echo "=================================================="
	@echo " SCS -                                            "
	@echo " Hubert, Paula, Marcello                          "
	@echo "=================================================="
	@echo " # Use 'make source-files' para ver a arquivos-fonte"
	@echo " # Compila��o na plataforma: $(UNAME)"

idl-generation:
	@echo " # Compilando idls do SCS..."
	@echo "    + Compilando scs.idl "
	@$(IDL_CMD) $(IDL_DIR)/scs.idl
	@echo "    + Compilando events.idl "
	@$(IDL_CMD) $(IDL_DIR)/events.idl
	@echo "    + Compilando deployment.idl "
	@$(IDL_CMD) $(IDL_DIR)/deployment.idl
	@echo "    + Compilando scs.instrumentation.idl "
	@$(IDL_CMD) $(IDL_DIR)/scs.instrumentation.idl
	@echo "    + Compilando reasoning.idl "
	@$(IDL_CMD) $(IDL_DIR)/reasoning.idl
#	@echo " "
#	@echo "    + Compilando pingPong.idl "
#	@$(IDL_CMD) $(IDL_DIR)/pingPong.idl
	@echo "    + Compilando philosopher.idl "
	@$(IDL_CMD) $(IDL_DIR)/philosopher.idl
	@echo "    + Compilando bigTable.idl "
	@$(IDL_CMD) $(IDL_DIR)/bigTable.idl
	@echo "    + Compilando mapreduce.idl "
	@$(IDL_CMD) $(IDL_DIR)/mapReduce.idl


scs-pkg:
	@echo " # Compilando fontes do SCS..."
	@echo "    + Compilando arquivos java "
	@$(JAVA_HOME)/javac -g -Xlint:-serial -deprecation -nowarn $(SCS_CORE_SRC_FILES) $(SCS_EXECUTION_NODE_SRC_FILES) $(SCS_CONTAINER_SRC_FILES) $(SCS_REASONING_SRC_FILES) $(SCS_MAPREDUCE_SRC_FILES) $(SCS_BIGTABLE_SRC_FILES) $(SCS_CHAT_SRC_FILES) $(SCS_PHILOSOPHER_SRC_FILES)
	@echo " # SCS compilado."

#
# Regras tempor�rias para gera��o dos arquivos de distribuicao do SCS.
# O processo oficial de versionamento e distribui��o dos pacotes ainda ser� 
# definido.
#

scs-jars: scs-jars-presentation scs-jars-dir $(SCS_JARS)
	@echo " # Jars gerados."
	@echo ""

scs-jars-presentation:
	@echo " # Gerando jars do SCS..."

scs-jars-dir:
	@mkdir -p $(SCS_JARS_DIR)

$(JAR_SCS_CORE): jar-scs-core
jar-scs-core:
	@echo "    + Core"
	@jar cf $(JAR_SCS_CORE) \
	scs/core/*.class scs/core/servant/*.class scs/event_service/*.class scs/event_service/servant/*.class 

$(JAR_SCS_EXECUTION_NODE): jar-scs-execution-node
jar-scs-execution-node:
	@echo "    + Execution Node."
	@jar cfm $(JAR_SCS_EXECUTION_NODE) \
         $(MANIFEST_DIR)/manifestExecutionNode.txt scs/execution_node/*.class scs/execution_node/servant/*.class

$(JAR_SCS_CONTAINER): jar-scs-container
jar-scs-container:
	@echo "    + Container."
	@jar cfm $(JAR_SCS_CONTAINER) \
         $(MANIFEST_DIR)/manifestContainer.txt scs/instrumentation/*.class scs/instrumentation/app/*.class \
         scs/instrumentation/servant/*.class scs/instrumentation/interceptor/*.class scs/container/*.class \
         scs/container/servant/*.class

#$(JAR_SCS_PINGPONG): jar-scs-pingpong
#jar-scs-pingpong:
#	@echo "    + PingPong."
#	@jar cfm $(JAR_SCS_PINGPONG) \
#         $(MANIFEST_DIR)/manifestPingPong.txt scs/demos/pingpong/*.class scs/demos/pingpong/servant/*.class 

clean: clean-scs-jars clean-scs-class

clean-scs-jars:
	@echo " # Apagando jars do SCS..."
	@rm -f $(SCS_JARS)
	@echo " # Jars apagados."

clean-scs-class:
	@echo " # Apagando class do SCS..."
	@rm scs/core/*.java
	@rm scs/core/*.class
	@rm scs/core/servant/*.class
	@rm scs/event_service/*.java
	@rm scs/event_service/*.class
	@rm scs/event_service/servant/*.class
	@rm scs/execution_node/*.java
	@rm scs/execution_node/*.class
	@rm scs/execution_node/servant/*.class
	@rm scs/instrumentation/*.java
	@rm scs/instrumentation/*.class
	@rm scs/instrumentation/app/*.class
	@rm scs/instrumentation/servant/*.class
	@rm scs/instrumentation/interceptor/*.class
	@rm scs/container/*.java
	@rm scs/container/*.class
	@rm scs/container/servant/*.class
#	@rm scs/demos/pingpong/*.java
#	@rm scs/demos/pingpong/*.class
#	@rm scs/demos/pingpong/servant/*.class
	@rm scs/demos/mapreduce/*.java
	@rm scs/demos/mapreduce/*.class
	@rm scs/demos/mapreduce/schedule/*.class
	@rm scs/demos/mapreduce/servant/*.class
	@rm scs/demos/mapreduce/app/*.class
	@rm scs/demos/mapreduce/user/*.class
	@rm scs/demos/bigtable/*.class
	@rm scs/demos/bigtable/servant/*.class
	@rm scs/demos/bigtable/test/*.class
	@rm scs/demos/bigtable/test/servant/*.class
	@rm scs/demos/bigtable/app/*.class
	@rm scs/demos/philosopher/*.java
	@rm scs/demos/philosopher/*.class
	@rm scs/demos/philosopher/servant/*.class
	@rm scs/auxiliar/*.java
	@rm scs/reasoning/*.java
#	@rm scs/reasoning/*.class
	@echo " # class apagados."


# ==========================================================================
# ===== DOCUMENTACAO =======================================================
# ==========================================================================

DOCDIR := ../../doc
JAVADOCDIR := $(DOCDIR)/java
WINDOWTITLE := 'SCS'
JAVADOCTITLE := '$(WINDOWTITLE) - Especifica��o da API'
HEADER := '<b>SCS</b>'
#BOTTOM := '<font size="-1"><a href="http://www.tecgraf.puc-rio.br/~scorrea/scs">Favor enviar sugest�es ou ocorr�ncias de erros.'
 
scs-doc: 
	@echo " # Gerando documenta��o JavaDoc"
	@rm -rf $(JAVADOCDIR)
	@mkdir -p $(JAVADOCDIR)
	@javadoc -quiet -d $(JAVADOCDIR) -sourcepath ./ -use -splitIndex -windowtitle $(WINDOWTITLE) -doctitle $(JAVADOCTITLE) -header $(HEADER) -J-Xmx180m -subpackages scs
	@chmod -R g+w $(JAVADOCDIR)
	@echo " # Documentacao concluida!"
	@echo ""


