FROM postgres:16

EXPOSE 5431

CMD ["postgres", "-c", "port=5431"]