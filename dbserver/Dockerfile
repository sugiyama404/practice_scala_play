FROM mysql:8.0.32-debian

# 公開鍵をダウンロードする
RUN curl -sSL https://repo.mysql.com/apt/debian/public.key | apt-key add -

RUN apt-get update \
    && apt-get -y install locales --no-install-recommends \
    && sed -i -e 's/# \(ja_JP.UTF-8\)/\1/' /etc/locale.gen \
    && locale-gen \
    && update-locale LANG=ja_JP.UTF-8 \
    && rm -rf /var/lib/apt/lists/*

ENV LC_ALL ja_JP.UTF-8
ENV TZ Asia/Tokyo
ENV LANG=ja_JP.UTF-8
