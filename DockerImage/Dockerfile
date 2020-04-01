FROM java:8

RUN curl http://www.h2database.com/h2-2017-04-23.zip -o h2.zip \
    && unzip h2.zip -d . \
    && rm h2.zip

VOLUME /h2-data

EXPOSE 8082 1521

CMD java -cp /h2/bin/h2*.jar org.h2.tools.Server \
 	-web -webAllowOthers -webPort 8082 \
 	-tcp -tcpAllowOthers -tcpPort 1521 \
	-baseDir /h2-data
