FROM mysql:8.0.32-debian

RUN sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys B7B3B788A8D3785C

RUN apt-get update && apt-get install -y locales \
    && sed -i -e 's/# \(ja_JP.UTF-8\)/\1/' /etc/locale.gen \
    && locale-gen \
    && update-locale LANG=ja_JP.UTF-8

ENV LC_ALL ja_JP.UTF-8
ENV TZ Asia/Tokyo
ENV LANG=ja_JP.UTF-8
